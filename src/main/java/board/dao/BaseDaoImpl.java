package board.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import board.annotation.ExTable;
import board.vo.ObjectMapper;

@Component
public class BaseDaoImpl<T, SEQ extends Serializable> implements BaseDao<T, SEQ> {
	
	@Autowired
	private SqlSessionTemplate template;
	
	
	@Override
	public T findBySeq(SEQ seq) {
		
		Class<T> clazz = getGenericClass();	
		
		Map<String, String> m = new HashMap<>();
		m.put("table", this.getTableName(clazz));
		m.put("seq", seq.toString());
		
		ObjectMapper mapper = template.selectOne("board.dao.BaseDao.findBySeq", m);
		
		return mapper.map(clazz);
	};
	
	@SuppressWarnings("unchecked")
	private Class<T> getGenericClass() {
		return (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	private String getTableName(Class<T> clazz) {
		ExTable tb = clazz.getAnnotation(ExTable.class);
		
		String table = "";
		
		if(tb != null) {
			table = tb.value();
		} else {
			table = clazz.getName().substring(clazz.getName().lastIndexOf(".") + 1);
		}
		
		return table;
	}
}

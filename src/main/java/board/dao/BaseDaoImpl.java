package board.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import board.vo.Mapping;
import board.vo.ObjectMapper;

@Component
public class BaseDaoImpl<T extends Mapping, SEQ extends Serializable> implements BaseDao<T, SEQ> {
	
	@Autowired
	private SqlSessionTemplate template;
	
	@Override
	public T findBySeq(SEQ seq) {
		
		Class<T> clazz = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		String table = clazz.getName().substring(clazz.getName().lastIndexOf(".") + 1);
		
		Map<String, String> m = new HashMap<>();
		m.put("table", table.toLowerCase());
		m.put("seq", seq.toString());
		
		ObjectMapper mapper = template.selectOne("board.dao.BaseDao.findBySeq", m);
		T t = mapper.map(clazz);
		
		return t;
	};
}

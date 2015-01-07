package board.vo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

public class ObjectMapper extends HashMap<String, Object> {
	public <T extends Mapping> T map(Class<T> clazz) {

		T t = null;
		
		try {
			t = clazz.newInstance();
			
			for(Method m : clazz.getMethods()) {
				if(m.getName().startsWith("set")) {
					
					String k = m.getName().replace("set", "").toUpperCase();
					m.invoke(t, this.get(k));
				}
			}
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return t;
	}
}

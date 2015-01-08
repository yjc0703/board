package board;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import board.config.TestConfig;
import board.dao.BaseDaoImpl;
import board.dao.UserDao;
import board.vo.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestConfig.class)
@WebAppConfiguration
public class UserDaoTest {
	
	@Autowired
	UserDao dao;
	
	@Autowired
	BaseDaoImpl<User, Integer> d;
	
	@Test
	public void tt() {
		
		
		
		User u = d.findBySeq(1);
		assertThat(u.getSeq(), is(1));
		assertThat(u.getUserId(), is("admin"));
		
	}

	@Test
	public void test() throws Exception {
		
		List<Map<String, String>> mapList = dao.selectAllUserMap();
		assertThat(mapList.size(), is(1));
		
		User a = new User();
		a.setUserId("admin2");
		a.setPassword("admin2");
		a.setUserName("관리자2");
		
		Integer i = dao.insertUser(a);
		assertThat(i, is(1));
		
		
		List<User> userList = dao.selectAllUser();
		assertThat(userList.size(), is(2));
		
		int seq = 0;
		
		for(User u : userList) {
			assertThat(u.getSeq(), is(++seq));
		}
	}
}

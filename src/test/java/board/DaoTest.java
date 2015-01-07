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
import board.dao.AdminDao;
import board.domain.Admin;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestConfig.class)
@WebAppConfiguration
public class DaoTest {
	
	@Autowired
	AdminDao dao;

	@Test
	public void test() throws Exception {
		List<Admin> adminList = dao.selectAdmin();
		assertThat(adminList.size(), is(1));
		
		
		Admin a = new Admin();
		a.setId(2);
		Integer i = dao.insertAdmin(a);
		System.out.println(i);
		
		List<Map<String, String>> mapList = dao.selectAdminMap();
		assertThat(mapList.size(), is(2));
		
		
	}
}

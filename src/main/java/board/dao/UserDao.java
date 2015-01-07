package board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import board.annotation.ExMapper;
import board.vo.User;

@ExMapper
public interface UserDao extends BaseDao<User, Integer> {
	List<User> selectAllUser();
	List<Map<String, String>> selectAllUserMap();
	Integer insertUser(@Param("user") User user);
}

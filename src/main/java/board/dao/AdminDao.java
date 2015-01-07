package board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import board.config.ExMapper;
import board.domain.Admin;

@ExMapper
public interface AdminDao {
	List<Admin> selectAdmin();
	List<Map<String, String>> selectAdminMap();
	Integer insertAdmin(@Param("a") Admin a);
}

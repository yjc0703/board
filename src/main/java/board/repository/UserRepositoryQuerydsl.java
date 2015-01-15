package board.repository;

import java.util.List;

import board.domain.User;

public interface UserRepositoryQuerydsl {
	List<User> findAllUserUsingQuerydsl();
}

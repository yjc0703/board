package board.repository.impl;

import java.util.List;

import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import board.domain.QUser;
import board.domain.User;
import board.repository.UserRepositoryQuerydsl;

public class UserRepositoryImpl extends QueryDslRepositorySupport implements UserRepositoryQuerydsl {
	
	public UserRepositoryImpl() {
		super(User.class);
	}
	
	@Override
	public List<User> findAllUserUsingQuerydsl() {
		QUser user = QUser.user;
		return from(user).list(user);
	}
}

package board.service.impl;

import org.springframework.stereotype.Service;

import board.domain.User;
import board.repository.UserRepository;
import board.service.UserService;

@Service
public class UserServiceImpl 
	extends BaseServiceImpl<User, Long, UserRepository> 
	implements UserService {
}

package board.repository;

import board.domain.User;

public interface UserRepository extends BaseRepository<User, Long>, UserRepositoryQuerydsl {

}

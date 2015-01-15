package board.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class User {
	@Id @GeneratedValue
	private Long seq;
	private String userId;
	private String password;
	private String userName;
}

package board.vo;

import lombok.Data;
import board.annotation.ExTable;

@Data
@ExTable(value = "user")
public class User {
	private Integer seq;
	private String userId;
	private String password;
	private String userName;
}

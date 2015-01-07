package board.vo;

import lombok.Data;

@Data
public class User implements Mapping {
	private Integer seq;
	private String userId;
	private String password;
	private String userName;
}

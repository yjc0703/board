package board.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

import org.hibernate.annotations.TypeDef;
import org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime;
import org.joda.time.LocalDateTime;

@Data
@Entity
@TypeDef(defaultForType = LocalDateTime.class, typeClass = PersistentLocalDateTime.class)
public class Comment {

	@Id @GeneratedValue
	private Long seq;
	
	private String content;
	
	private LocalDateTime regDate;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "boardSeq")
	private Board board;
	
}

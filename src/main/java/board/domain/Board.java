package board.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.TypeDef;
import org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime;
import org.joda.time.LocalDateTime;

import lombok.Data;

@Data
@Entity
@TypeDef(defaultForType = LocalDateTime.class, typeClass = PersistentLocalDateTime.class)
public class Board {

	@Id @GeneratedValue
	private Long seq;
	
	private String title;
	private String content;
	
	private LocalDateTime regDate;
	
	@ManyToOne
	private User user;
	@OneToMany(mappedBy = "board")
	private List<Comment> comment;
}

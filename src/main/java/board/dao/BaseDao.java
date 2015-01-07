package board.dao;

import java.io.Serializable;

public interface BaseDao<T, SEQ extends Serializable> {
	T findBySeq(SEQ seq);
}

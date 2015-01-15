package board.service.impl;

import java.io.Serializable;

import board.repository.BaseRepository;
import board.service.BaseService;

public class BaseServiceImpl<T, ID extends Serializable, R extends BaseRepository<T, ID>> implements BaseService<T, ID, R> {
	
	protected R r;
}

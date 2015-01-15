package board.service;

import java.io.Serializable;

import board.repository.BaseRepository;

public interface BaseService<T, ID extends Serializable, R extends BaseRepository<T, ID>> {

}

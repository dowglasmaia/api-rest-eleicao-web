package org.maia.web.eleicao.services.factory;

import org.springframework.data.domain.Pageable;
import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public interface ICrudFactory<T, PK> extends Serializable {

	@Transactional(rollbackFor = Exception.class)
	T save(T entity);

	@Transactional(rollbackFor = Exception.class)
	T update(T entity);

	@Transactional(readOnly = true)
	T findById(PK id);

	@Transactional(rollbackFor = Exception.class)
	void delete(PK id);

	@Transactional(readOnly = true)
	Page<T> findAll(T entity, Pageable page);

	@Transactional(readOnly = true)
	List<T> findAll();
}

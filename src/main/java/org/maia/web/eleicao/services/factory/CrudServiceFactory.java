package org.maia.web.eleicao.services.factory;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public abstract class CrudServiceFactory<T, PK extends Serializable> implements ICrudServiceFactory<T, PK> {
	private static final long serialVersionUID = 1L;

	private final JpaRepository<T, PK> repository;

	@Autowired
	public CrudServiceFactory(JpaRepository<T, PK> repository) {
		this.repository = repository;
	}

	@Override
	public T save(T entity) {
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public T update(T entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(PK id) {
		// TODO Auto-generated method stub

	}

	@Override
	public T findById(PK id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}

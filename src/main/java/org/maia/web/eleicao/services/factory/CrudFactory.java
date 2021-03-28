package org.maia.web.eleicao.services.factory;


import java.io.Serializable;
import java.util.List;

import org.maia.web.eleicao.execptions.ObjectNotFoundException;
import org.maia.web.eleicao.execptions.OperationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j	
@Service
public abstract class CrudFactory<T, PK extends Serializable> implements ICrudFactory<T, PK> {
	private static final long serialVersionUID = 1L;

	private final JpaRepository<T, PK> repository;

	@Autowired
	public CrudFactory(JpaRepository<T, PK> repository) {
		this.repository = repository;
	}

	@Override
	public T save(T entity) {
		try {
			return repository.save(entity);
		} catch (Exception e) {
			log.error("Falha ao tentar salvar recurso.", e.getCause());
			throw new OperationException("Falha ao tentar salvar recurso.", e.getCause());
		}
	}

	@Override
	public T update(T entity) {
		try {
			return repository.save(entity);
		} catch (Exception e) {
			log.error("Falha ao tentar atualizar o recurso.", e.getCause());
			throw new OperationException("Falha ao tentar atualizar o recurso.", e.getCause());
		}
	}

	@Override
	public void delete(PK id) {
		try {
			repository.deleteById(id);
		} catch (Exception e) {
			log.error("Falha ao tentar excluir o recurso de ID " + id, e.getCause());
			throw new OperationException("Falha ao tentar excluir o recurso de ID " + id, e.getCause());
		}
	}

	@Override
	public T findById(PK id) {
		log.info("Listando dado por id");
		return repository.findById(id).orElseThrow(
					() -> new ObjectNotFoundException("Recurso não encontrado para o ID "+ id));		
	}	

	@Override
	public List<T> findAll() {
		return repository.findAll();
	}
	
	@Override
	public Page<T> findAll(T entity, Pageable page) {
		log.info("Listando dados com paginação");
		Example<T> example = Example.of(entity, ExampleMatcher
				.matching()
				.withIgnoreCase()
				.withIgnoreNullValues()
				.withStringMatcher( ExampleMatcher.StringMatcher.CONTAINING ));
				
		return repository.findAll(example, page);
	}

}

package org.maia.web.eleicao.services.impl;

import org.maia.web.eleicao.domain.Eleitor;
import org.maia.web.eleicao.domain.dto.EleitorDTO;
import org.maia.web.eleicao.domain.dto.EleitorDTOBuilder;
import org.maia.web.eleicao.repository.EleitorRepository;
import org.maia.web.eleicao.services.IEleitorServices;
import org.maia.web.eleicao.services.factory.CrudServiceFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EleitorServices extends CrudServiceFactory<Eleitor, Long> implements IEleitorServices {
	private static final long serialVersionUID = 1L;

	private EleitorRepository repository;

	@Autowired
	public EleitorServices(EleitorRepository repository) {
		super(repository);
		this.repository = repository;
	}

	@Override
	public Eleitor toEleitor(EleitorDTOBuilder dto) {		
		return new ModelMapper().map(dto, Eleitor.class);
	}

	@Override
	public EleitorDTO toDTO(Eleitor eletior) {
		return new ModelMapper().map(eletior, EleitorDTO.class);
	}

}


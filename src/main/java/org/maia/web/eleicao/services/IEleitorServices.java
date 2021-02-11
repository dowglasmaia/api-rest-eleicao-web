package org.maia.web.eleicao.services;

import org.maia.web.eleicao.domain.Eleitor;
import org.maia.web.eleicao.domain.dto.EleitorDTO;
import org.maia.web.eleicao.domain.dto.EleitorDTOBuilder;
import org.maia.web.eleicao.services.factory.ICrudServiceFactory;
import org.springframework.stereotype.Service;

@Service
public interface IEleitorServices extends ICrudServiceFactory<Eleitor, Long> {
	
	Eleitor toEleitor(EleitorDTOBuilder dto);
	
	EleitorDTO toDTO(Eleitor eletior);

}

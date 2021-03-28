package org.maia.web.eleicao.services.interfaces;

import org.maia.web.eleicao.domain.dto.VotoDTOBuilder;
import org.springframework.stereotype.Service;

@Service
public interface VotoServices {
	
    void realizarVoto(VotoDTOBuilder voto);
}

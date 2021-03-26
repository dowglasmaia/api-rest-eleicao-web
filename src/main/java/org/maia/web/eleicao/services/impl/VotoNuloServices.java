package org.maia.web.eleicao.services.impl;

import org.maia.web.eleicao.domain.dto.VotoDTOBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class VotoNuloServices {

    private static Logger log = LoggerFactory.getLogger(VotoNuloServices.class);

    public void save(VotoDTOBuilder voto) {
        log.info("Validando se Usuario estar autenticado.");

        log.info("Validando Votos Duplicados.");

        log.info("Validando Perfil de Eleitor.");

        log.info("Realizando Votos.");
    }
}

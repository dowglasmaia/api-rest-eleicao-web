package org.maia.web.eleicao.services.impl;

import org.maia.web.eleicao.domain.dto.VotoDTOBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VotoValidoServices {

    private static Logger log = LoggerFactory.getLogger(VotoValidoServices.class);


    public void save(VotoDTOBuilder voto) {

        log.info("Validando se Usuario estar autenticado.");

        log.info("Validando Votos Duplicados.");

        log.info("Validando Perfil de Eleitor.");

        log.info("Realizando Votos.");

    }
}

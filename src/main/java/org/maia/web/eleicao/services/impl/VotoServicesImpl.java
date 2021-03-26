package org.maia.web.eleicao.services.impl;


import org.maia.web.eleicao.domain.dto.VotoDTOBuilder;
import org.maia.web.eleicao.services.interfaces.VotoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class VotoServicesImpl implements VotoServices {

    private static Logger log = LoggerFactory.getLogger(VotoServicesImpl.class);

    private final VotoNuloServices votoNuloServices;
    private final VotoBrancoServices votoBrancoServices;
    private final VotoValidoServices votoValidoServices;

    @Autowired
    public VotoServicesImpl(
            VotoNuloServices votoNuloServices,
            VotoBrancoServices votoBrancoServices,
            VotoValidoServices votoValidoServices
    ) {
        this.votoNuloServices = votoNuloServices;
        this.votoBrancoServices = votoBrancoServices;
        this.votoValidoServices = votoValidoServices;
    }

    @Override
    public void realizarVoto(VotoDTOBuilder voto) {
        switch (voto.getTipo()) {
            case BRANCO:
                log.info("Iniciando processo para salvar Voto Branco");
                this.votoBrancoServices.save(voto);
                break;

            case VALIDO:
                this.votoValidoServices.save(voto);
                log.info("Iniciando processo para salvar Voto Válido");
                break;

            case NULO:
                this.votoNuloServices.save(voto);
                log.info("Iniciando processo para salvar Voto Nulo");
                break;

            default:
                log.info("Tipo de Voto Inválido");
                throw new RuntimeException("Tipo de Voto Inválido");
        }
    }


}

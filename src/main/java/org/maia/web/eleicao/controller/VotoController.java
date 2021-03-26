package org.maia.web.eleicao.controller;

import org.maia.web.eleicao.domain.dto.VotoDTOBuilder;
import org.maia.web.eleicao.domain.enums.TipoVoto;
import org.maia.web.eleicao.services.interfaces.VotoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/votos")
public class VotoController {

    private VotoServices services;

    @Autowired
    public VotoController(VotoServices services) {
        this.services = services;
    }

    @PostMapping(produces = {"application/json", "application/xml"},
            consumes = {"application/json", "application/xml"})
    public ResponseEntity<Void> realizarVotoValido( @RequestBody VotoDTOBuilder voto) {
       // VotoDTOBuilder vt = new VotoDTOBuilder(TipoVoto.VALIDO,"Presidente");


        services.realizarVoto(voto);


        return ResponseEntity.ok().build();
    }

}

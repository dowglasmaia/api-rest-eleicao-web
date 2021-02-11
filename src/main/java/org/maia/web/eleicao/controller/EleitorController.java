package org.maia.web.eleicao.controller;

import java.net.URI;

import javax.validation.Valid;

import org.maia.web.eleicao.domain.Eleitor;
import org.maia.web.eleicao.domain.dto.EleitorDTO;
import org.maia.web.eleicao.domain.dto.EleitorDTOBuilder;
import org.maia.web.eleicao.services.IEleitorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("api/v1/eleitores")
public class EleitorController {

	private final IEleitorServices services;

	@Autowired
	public EleitorController(IEleitorServices services) {
		this.services = services;
	}

	@PostMapping(produces = { "application/json","application/xml" }, 
				 consumes = { "application/json","application/xml" })
	public ResponseEntity<Void> createEleitor(@Valid @RequestBody EleitorDTOBuilder dto) {
		Eleitor entity = services.toEleitor(dto);
		services.save(entity);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(entity.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping(value = "/{id}", produces = { "application/json", "application/xml" })
	public ResponseEntity<EleitorDTO> findById(@PathVariable("id") Long id) {		
		Eleitor entity = services.findById(id);				
		EleitorDTO dto = services.toDTO(entity);
			
		return ResponseEntity.ok().body(dto);
	}

}

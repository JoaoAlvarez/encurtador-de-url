package com.encurtadorurl.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.encurtadorurl.dto.AcessoDTO;
import com.encurtadorurl.services.HistoricoAcessoService;

@RestController
@RequestMapping(value = "/historico")
public class HistoricoAcessoResource {

	@Autowired
	private HistoricoAcessoService service;
	
	@RequestMapping(value = "/{referencia}", method = RequestMethod.GET)
	public ResponseEntity<AcessoDTO> statusURL(@PathVariable String referencia){
		AcessoDTO acesso = service.status(referencia);		
		return ResponseEntity.ok().body(acesso);
	}
}

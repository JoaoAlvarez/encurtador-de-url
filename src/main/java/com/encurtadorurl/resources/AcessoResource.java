package com.encurtadorurl.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.encurtadorurl.domain.Acesso;
import com.encurtadorurl.services.AcessoService;

@RestController
@RequestMapping(value="/")
public class AcessoResource {
	
	@Autowired
	private AcessoService service;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<String> insert(@RequestBody Acesso obj){
		String referenciaURL = service.insert(obj); 
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{URLReduzida}").buildAndExpand(referenciaURL).toUri();
		
		return ResponseEntity.created(uri).body(uri.getHost()+uri.getPath());
	}
	
	@RequestMapping(value="/{referencia}",method=RequestMethod.GET)
	public ResponseEntity<String> goToUrl(@PathVariable String referencia) {
		return ResponseEntity.ok().body(service.findByShortURL(referencia).getUrl());
		
		/*
		 * if (obj == null) { return
		 * ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); } String redirectTo =
		 * obj.getOriginalURL(); if (!redirectTo.substring(0,
		 * HTTP_PREFIX.length()).equals(HTTP_PREFIX) && !redirectTo.substring(0,
		 * HTTPS_PREFIX.length()).equals(HTTPS_PREFIX)) { redirectTo =
		 * HTTP_PREFIX.concat(redirectTo); } URI uri = new URI(redirectTo); HttpHeaders
		 * httpHeaders = new HttpHeaders(); httpHeaders.setLocation(uri); return new
		 * ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER); }
		 */
	
	}
}

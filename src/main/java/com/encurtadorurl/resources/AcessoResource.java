package com.encurtadorurl.resources;

import java.net.URI;
import java.net.URISyntaxException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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
@RequestMapping(value = "/")
public class AcessoResource {

	@Autowired
	private AcessoService service;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> insert(@Valid @RequestBody Acesso obj) {
		String referenciaURL = service.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{URLReduzida}").buildAndExpand(referenciaURL).toUri();

		return ResponseEntity.created(uri).body(uri.getHost() + uri.getPath());
	}

	@RequestMapping(value = "/{referencia}", method = RequestMethod.GET)
	public ResponseEntity<String> goToUrl(@PathVariable String referencia) throws URISyntaxException {
		Acesso acesso = service.findURL(referencia);

		//Trecho de codigo utilizado para redirecionar o usuario para a pagina desejada
		HttpHeaders httpHeaders = new HttpHeaders(); 
		httpHeaders.setLocation(new URI(acesso.getUrl())); 
		
		return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
	}
	
	@RequestMapping(value = "/status/{referencia}", method = RequestMethod.GET)
	public ResponseEntity<Acesso> statusURL(@PathVariable String referencia){
		Acesso acesso = service.findURL(referencia);		
		return ResponseEntity.ok().body(acesso);
	}
}

package com.encurtadorurl.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encurtadorurl.domain.Acesso;
import com.encurtadorurl.repositories.AcessoRepository;
import com.encurtadorurl.resources.utils.IDConverter;
import com.encurtadorurl.services.exceptions.ObjectNotFoundException;

@Service
public class AcessoService {
	
	@Autowired
	private AcessoRepository repository;
	
	private IDConverter converter = IDConverter.getInstance();
	
	public String insert(Acesso obj) {
		Acesso acesso = repository.findByUrl(obj.getUrl());
		if(acesso == null) {
			obj.setId(null);
			obj = repository.save(obj);
			
			try {
				obj.setReferencia(converter.toBase62(String.valueOf(obj.getId())));
			}catch(NumberFormatException e) {
				repository.delete(obj);
				throw new NumberFormatException("Erro ao tentar encurtar URL:"+obj.getUrl());
			}
			acesso = repository.save(obj); 
		}
		
		return acesso.getReferencia();
	}
	
	public Acesso findByShortURL(String refURL) {
		Optional<Acesso> obj = repository.findByReferencia(refURL);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Nenhum link encontrado com a referencia " + refURL));
	}
}

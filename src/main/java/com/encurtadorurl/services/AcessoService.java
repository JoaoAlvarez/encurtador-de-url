package com.encurtadorurl.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encurtadorurl.domain.Acesso;
import com.encurtadorurl.repositories.AcessoRepository;
import com.encurtadorurl.services.exceptions.ObjectNotFoundException;
import com.encurtadorurl.services.utils.IDConverter;
import com.encurtadorurl.utils.Constantes;

@Service
public class AcessoService {
	
	@Autowired
	private AcessoRepository acessoRepository;
	
	@Autowired
	private HistoricoAcessoService historicoService;
	
	private IDConverter converter = IDConverter.getInstance();
	
	public String insert(Acesso obj) {
		Acesso acesso = acessoRepository.findByUrl(obj.getUrl());
		if(acesso == null) {
			obj.setId(null);
			obj = acessoRepository.save(obj);
			
			try {
				obj.setReferencia(converter.toBase62(String.valueOf(obj.getId())));
			}catch(NumberFormatException e) {
				acessoRepository.delete(obj);
				throw new NumberFormatException(Constantes.Error.ERRO_AO_ENCURTUAR_URL.getMessage() + obj.getUrl());
			}
			acesso = acessoRepository.save(obj); 
		}
		
		return acesso.getReferencia();
	}
	
	public Acesso findByShortURL(String refURL) {
		Optional<Acesso> obj = acessoRepository.findByReferencia(refURL);
		return obj.orElseThrow(() -> new ObjectNotFoundException(Constantes.Error.REFERENCIA_NAO_ENCONTRADA.getMessage() + refURL));
	}
	
	public Acesso findURL(String refURL) {
		Acesso obj = findByShortURL(refURL);
		historicoService.insert(obj);
		return obj;
	}
}

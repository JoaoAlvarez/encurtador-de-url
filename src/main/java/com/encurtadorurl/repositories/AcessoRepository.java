package com.encurtadorurl.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.encurtadorurl.domain.Acesso;

@Repository
public interface AcessoRepository  extends MongoRepository<Acesso,String>{
	
	@Transactional(readOnly=true)
	Optional<Acesso> findByReferencia(String referencia);
	
	@Transactional(readOnly=true)
	Acesso findByUrl(String url);
}



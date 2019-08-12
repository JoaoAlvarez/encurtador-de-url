package com.encurtadorurl.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.encurtadorurl.domain.Acesso;
import com.encurtadorurl.domain.HistoricoAcesso;

@Repository
public interface HistoricoAcessoRepository extends MongoRepository<HistoricoAcesso, String> {

	@Transactional(readOnly = true)
	List<HistoricoAcesso> findByAcesso(Acesso acesso);
}

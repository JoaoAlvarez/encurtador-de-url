package com.encurtadorurl.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encurtadorurl.domain.Acesso;
import com.encurtadorurl.domain.HistoricoAcesso;
import com.encurtadorurl.dto.AcessoDTO;
import com.encurtadorurl.repositories.HistoricoAcessoRepository;

@Service
public class HistoricoAcessoService {

	@Autowired
	private AcessoService acessoService;

	@Autowired
	private HistoricoAcessoRepository historicoAcessoRepository;

	public void insert(Acesso obj) {
		HistoricoAcesso ha = new HistoricoAcesso(null, obj, new Date());
		historicoAcessoRepository.save(ha);
	}

	public AcessoDTO status(String refURL) {
		Acesso acesso = acessoService.findByShortURL(refURL);
		List<HistoricoAcesso> historico = historicoAcessoRepository.findByAcesso(acesso);

		return new AcessoDTO(acesso, historico);
	}
}

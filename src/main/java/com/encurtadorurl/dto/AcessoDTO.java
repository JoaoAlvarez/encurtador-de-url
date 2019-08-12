package com.encurtadorurl.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;

import com.encurtadorurl.domain.Acesso;
import com.encurtadorurl.domain.HistoricoAcesso;

public class AcessoDTO {
	
	@Id
	private String id;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String url;
	
	private String referencia;
	
	private int quantidadeAcessos;
	
	private List<HistoricoAcesso> historico;

	public AcessoDTO() {}
	
	public AcessoDTO(Acesso acesso, List<HistoricoAcesso> historico) {
		super();
		this.id = acesso.getId();
		this.url = acesso.getUrl();
		this.referencia = acesso.getReferencia();
		this.quantidadeAcessos = historico.size();
		this.historico = historico;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public int getQuantidadeAcessos() {
		return quantidadeAcessos;
	}

	public void setQuantidadeAcessos(int quantidadeAcessos) {
		this.quantidadeAcessos = quantidadeAcessos;
	}

	public List<HistoricoAcesso> getHistorico() {
		return historico;
	}

	public void setHistorico(List<HistoricoAcesso> historico) {
		this.historico = historico;
	}
	
}

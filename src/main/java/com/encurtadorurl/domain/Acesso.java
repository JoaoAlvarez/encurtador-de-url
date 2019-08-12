package com.encurtadorurl.domain;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.encurtadorurl.resources.validation.AcessoInsert;

@AcessoInsert
@Document(collection="acesso")
public class Acesso implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String url;
	
	private String referencia;
	
	public Acesso() {}

	public Acesso(String id, String url, String referencia) {
		super();
		this.id = id;
		this.url = url;
		this.referencia = referencia;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Acesso other = (Acesso) obj;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}
	
}

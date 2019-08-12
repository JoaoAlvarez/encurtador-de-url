package com.encurtadorurl.utils;

public class Constantes {
	public static class ErrorEnum {
		String mensagem;
		int erroCode;
		public ErrorEnum(String mensagem, int erroCode) {
			this.mensagem = mensagem;
			this.erroCode = erroCode;
		}
		public int getCode(){
			return erroCode;
		}
		public String getMessage(){
			return mensagem;
		}
	}

	public static interface Error {
		ErrorEnum ERRO_AO_ENCURTUAR_URL = new ErrorEnum("Erro ao tentar encurtar URL ",0);
		ErrorEnum REFERENCIA_NAO_ENCONTRADA = new ErrorEnum("Nenhum link encontrado com a referencia ", 1);
		}
}

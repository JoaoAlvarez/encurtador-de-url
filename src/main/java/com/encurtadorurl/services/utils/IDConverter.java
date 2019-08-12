package com.encurtadorurl.services.utils;

import java.math.BigInteger;

//PARA OTIMIZAR O TEMPO E NÃO "REESCREVER A RODA" PESQUISEI UM CODIGO LIMPO, ROBUSTO E QUE FOSSE DE MESMO OBJETIVO
//FONTE DO CODIGO : https://github.com/tyronedamasceno/URLShortener/blob/master/src/main/java/com/example/demo/IDConverter.java

/* OBS1.: TRECHOS DE CODIGOS FORAM REMOVIDOS POR NÃO SEREM UTILIZADOS NESSE PROJETO
 * OBS2.: FORAM FEITAS ALTERACOES PARA SER COMPATIVEL COM O ID USADO PELO MONGODB 
 * 		Foi necessario utilizar BigInteger no ao invez de Integer/int, com isso,
 * 		 os calculos e comparacoes de valores tambem foram alterados.
*/

public class IDConverter {

	private static IDConverter INSTANCE;
	private static String baseCharacters;
	public static final Integer BASE = 62;
	
	private IDConverter() {
		initialize();
	}

	public static synchronized IDConverter getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new IDConverter();
		}
		return INSTANCE;
	}
	
	public String toBase62(String input) {
		
		BigInteger bigInt = new BigInteger(input, 16);
		if (bigInt.compareTo(BigInteger.ZERO) == 0) return "0";
		String output = "";
		while (bigInt.compareTo(BigInteger.ZERO) > 0) {
			BigInteger base = BigInteger.valueOf(BASE);
			BigInteger remain = bigInt.remainder(base);
			
			output += baseCharacters.charAt(Integer.parseInt(remain.toString()));
			bigInt = bigInt.divide(BigInteger.valueOf(BASE));
		}
		
		while (output.length() < 5) {
			output = "0".concat(output);
		}
		
		return output;
	}
	
	private void initialize() {
		baseCharacters = "";
		for (char i = '0'; i <= '9'; i++) baseCharacters += i;
		for (char i = 'a'; i <= 'z'; i++) baseCharacters += i;
		for (char i = 'A'; i <= 'Z'; i++) baseCharacters += i;
	}

}
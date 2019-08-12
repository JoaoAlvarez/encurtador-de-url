package com.encurtadorurl.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.encurtadorurl.domain.Acesso;
import com.encurtadorurl.repositories.AcessoRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private AcessoRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		
		repository.deleteAll();
		
		Acesso ac1 = new Acesso(null, "http://facebook.com.br","fb");
		Acesso ac2 = new Acesso(null, "http://google.com.br","goo");
		Acesso ac3 = new Acesso(null, "https://g1.globo.com/","g1");
		
		repository.saveAll(Arrays.asList(ac1,ac2,ac3));
		
	}

}

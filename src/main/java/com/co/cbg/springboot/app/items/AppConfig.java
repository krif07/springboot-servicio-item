package com.co.cbg.springboot.app.items;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

	/*
	 * Cliente http para trabjar con api rest y así acceder a recursos que están en otros microservicios
	 * El objeto retornado de tipo rest template se guarda en el contenedor gracias a @Bean
	 * */
	@Bean("clienteRestProducto")
	public RestTemplate registrarRestTemplate() {
		return new RestTemplate();
	}
}

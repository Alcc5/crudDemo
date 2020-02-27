package br.com.cartorio.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;

import br.com.cartorio.model.Cartorio;
import br.com.cartorio.repository.CartorioRepository;

@SpringBootConfiguration
public class AppConfig {

	@Bean
	public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> webServerFactoryCustomizer() {
		return factory -> factory.setContextPath("/projeto");
	}

	@Bean
	public boolean demo(CartorioRepository cartorioRepository) {
		cartorioRepository.save(new Cartorio("a"));
		cartorioRepository.save(new Cartorio("b"));
		cartorioRepository.save(new Cartorio("c"));
		return true;
	}

}

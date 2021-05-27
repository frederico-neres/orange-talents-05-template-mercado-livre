package br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class TreinoMercadoLivreApplication {

	public static void main(String[] args) {
		SpringApplication.run(TreinoMercadoLivreApplication.class, args);
	}

}

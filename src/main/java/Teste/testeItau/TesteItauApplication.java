package Teste.testeItau;

import Teste.testeItau.Estatistica.EstatisticaProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(EstatisticaProperties.class)
public class TesteItauApplication {

	public static void main(String[] args) {
		SpringApplication.run(TesteItauApplication.class, args);
	}

}

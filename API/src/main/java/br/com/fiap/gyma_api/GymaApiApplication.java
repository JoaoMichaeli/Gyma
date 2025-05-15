package br.com.fiap.gyma_api;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@OpenAPIDefinition(
		info =  @Info(title = "Gyma API", version = "v1", description = "API do SaaS Gyma")
)
@EnableCaching
public class GymaApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(GymaApiApplication.class, args);
	}
}

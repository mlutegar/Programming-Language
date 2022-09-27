package br.com.tudocelular.gestaolojacelular;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GestaoLojaCelularApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestaoLojaCelularApplication.class, args);
    }

    @Bean
    public OpenAPI openApiConfig() {
        return new OpenAPI().info(apiInfo());
    }

    private Info apiInfo() {
        return new Info()
                .title("Gestão de uma loja de celulares")
                .description("Sistema que gere o cadastro de funcionários")
                .version("1.0.0");
    }

}


package br.com.iago.gerenciador_tarefas.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI configurarDocumentacao() {
        return new OpenAPI()
                .info(new Info()
                        .title("Gerenciador de Tarefas API")
                        .version("1.0")
                        .description("API REST para cadastro, consulta, atualização e exclusão de tarefas pessoais."));
    }
}

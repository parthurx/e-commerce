package e_commerce.com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // Desabilita CSRF para simplificar (não recomendado em produção)
                .authorizeHttpRequests()
                .requestMatchers(
                        "/users", // Permite POST /users
                        "/v3/api-docs/**", // Swagger
                        "/swagger-ui/**", // Swagger UI
                        "/swagger-ui.html" // Swagger UI
                ).permitAll() // Permite acesso público às rotas especificadas
                .anyRequest().authenticated() // Exige autenticação para todas as outras rotas
                .and()
                .formLogin().disable(); // Desabilita o formulário de login padrão
        return http.build();
    }

    Dotenv dotenv = Dotenv.load();
    String appName = dotenv.get("SPRING_APPLICATION_NAME");
    String dbUrl = dotenv.get("SPRING_DATASOURCE_URL");
    String dbUsername = dotenv.get("SPRING_DATASOURCE_USERNAME");
    String dbPassword = dotenv.get("SPRING_DATASOURCE_PASSWORD");
}
package it.smartworki.dating_app;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Dating App API",
                version = "1.0.0",
                description = "Documentazione delle API per l'applicazione Dating App",
                termsOfService = "https://www.example.com/terms",
                contact = @Contact(
                        name = "Supporto Tecnico",
                        email = "supporto@example.com",
                        url = "https://www.example.com/"
                ),
                license = @License(
                        name = "Licenza Apache 2.0",
                        url = "https://www.apache.org/licenses/LICENSE-2.0.html"
                )
        )
)
public class DatingAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(DatingAppApplication.class, args);

    }
}
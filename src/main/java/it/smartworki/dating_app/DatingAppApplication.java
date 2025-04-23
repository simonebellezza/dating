package it.smartworki.dating_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "it.smartworki.dating_app.entities")
public class DatingAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(DatingAppApplication.class, args);

    }
}
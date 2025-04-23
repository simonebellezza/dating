package it.smartworki.dating_app.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.List;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();

        // Permette l'invio di cookie, Authorization header ecc.
        config.setAllowCredentials(true);

        // Configurazione delle origini consentite
        config.setAllowedOrigins(Arrays.asList(
                "http://localhost:3000",
                "http://192.168.1.101:3000",
                "http://10.0.2.2:8081"
        ));

        // Configurazione dei metodi consentiti
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));

        // Configurazione degli headers consentiti
        config.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type", "Accept"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }
}

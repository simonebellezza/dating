package it.smartworki.dating_app.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO per la richiesta di login.
 * Contiene le credenziali minime necessarie per autenticare un utente.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestDTO {

    @NotBlank(message = "L'email non può essere vuota")
    @Email(message = "L'email deve essere valida")
    private String email;

    @NotBlank(message = "La password non può essere vuota")
    @Size(min = 8, message = "La password deve contenere almeno 8 caratteri") // Da verificare
    private String password;
}
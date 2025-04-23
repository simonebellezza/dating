package it.smartworki.dating_app.dtos;

import it.smartworki.dating_app.entities.enums.AccountType;
import it.smartworki.dating_app.validators.Adult;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserRequestDTO {

    @NotBlank(message = "Il nome è obbligatorio")
    private String name;

    @NotBlank(message = "L'email è obbligatoria")
    @Email(message = "Email non valida")
    private String email;

    @NotBlank(message = "La password è obbligatoria")
    @Size(min = 8, max = 255, message = "La password deve essere tra 8 e 255 caratteri")
    private String password;

    @NotNull(message = "La data di nascita è obbligatoria")
    @Past(message = "La data di nascita deve essere nel passato")
    private LocalDate birthday;

    @Size(max = 1000, message = "La bio può contenere al massimo 1000 caratteri")
    private String bio;
}
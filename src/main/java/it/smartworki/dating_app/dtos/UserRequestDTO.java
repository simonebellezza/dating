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
    @NotBlank(message = "Name must be not null")
    private String name;

    @NotBlank(message = "Email must be not null")
    @Email(message = "Email must be valid")
    private String email;

    @NotBlank(message = "Password must be not null")
    @Size(min = 8, max = 255, message = "Password must be between 8 and 255 characters")
    private String password;

    @NotNull
    @Past(message = "Birthday must be in the past")
    @Adult
    private LocalDate birthday;

    @Size(max = 1000, message = "Bio must be max 1000 characters")
    private String bio;
}

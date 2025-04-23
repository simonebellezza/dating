package it.smartworki.dating_app.dtos;

import it.smartworki.dating_app.entities.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserResponseDTO {
    private Long id;
    private String name;
    private String email;
    private LocalDate birthday;
    private String bio;
    private AccountType accountType;
    private LocalDate registrationDate;
    // private String imagePath;
    private int age;
    private Set<String> genres;
    private PreferenceResponseDTO preferences;
}
package it.smartworki.dating_app.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.smartworki.dating_app.entities.enums.AccountType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;

    @Column(name = "bio")
    private String bio;

    @Column(name = "account_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private AccountType accountType = AccountType.STANDARD;

    @Column(name = "registration_date")
    private LocalDate registrationDate = LocalDate.now();

    // ---------- Relazioni ----------

    // Preference 1:1
    @OneToOne(mappedBy = "user")
    @JsonIgnoreProperties("user")
    private Preference preference;

    // UserDetail 1:1
    @OneToOne(mappedBy = "user")
    @JsonIgnoreProperties("user")
    private UserDetail userDetail;

    // InterestUser 1:N
    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties("user")
    private Set<InterestUser> interests;

    // GenreUser 1:N
    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties("user")
    private Set<GenreUser> genres;

    // Role 1:1
    @OneToOne(mappedBy = "user")
    @JsonIgnoreProperties("user")
    private Role role;
}
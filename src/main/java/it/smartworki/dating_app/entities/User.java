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

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "bio")
    private String bio;

    @Column(name = "account_type")
    private AccountType accountType;

    @Column(name = "registration_date")
    private LocalDate registrationDate;

    // ---------- Relazioni ----------

    // Preference 1:1
    @OneToOne(mappedBy = "user")
    @JsonIgnoreProperties("user")
    private Preference preference;

    // UserDetail 1:1
    @OneToOne(mappedBy = "user")
    @JsonIgnoreProperties("user")
    private UserDetail userDetail;

    // (Doppia) Match 1:N, 1:N
    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties("user")
    private List<Match> matchesAsUser;

    @OneToMany(mappedBy = "userTarget")
    @JsonIgnoreProperties("userTarget")
    private List<Match> matchesAsTarget;

    // Interest 1:N
    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties("user")
    private Set<Interest> interests;

    // Genre 1:N
    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties("user")
    private Set<Genre> genres;

    // Role 1:1
    @OneToOne(mappedBy = "user")
    @JsonIgnoreProperties("user")
    private Role role;
}
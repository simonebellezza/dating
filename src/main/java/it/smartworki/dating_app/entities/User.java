package it.smartworki.dating_app.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.smartworki.dating_app.entities.enums.AccountType;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.*;

import java.time.LocalDate;
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

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "email", nullable = false, unique = true, length = 255)
    private String email;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;

    @Column(name = "bio", length = 255)
    private String bio;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_type", nullable = false)
    private AccountType accountType = AccountType.STANDARD;

    @Column(name = "registration_date")
    private LocalDate registrationDate = LocalDate.now();

    @Column(name = "fcm_token")
    private String fcmToken;

    // ---------- Relazioni ----------

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("user")
    private Preference preference;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("user")
    private UserDetail userDetail;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("user")
    private Role role;

    @ManyToMany
    @JsonIgnoreProperties("user")
    @JoinTable(name = "interest_user",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "interest_id"))
    private Set<Interest> interests;

    @ManyToMany
    @JoinTable(name = "genre_user",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    @JsonIgnoreProperties("user")
    private Set<Genre> genres;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("user")
    private Set<Swipe> swipesSent;

    @OneToMany(mappedBy = "userTarget", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("userTarget")
    private Set<Swipe> swipesReceived;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("user")
    private Set<Match> matchesInitiated;

    @OneToMany(mappedBy = "userTarget", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("userTarget")
    private Set<Match> matchesReceived;

    @OneToMany(mappedBy = "sender")
    @JsonIgnoreProperties("sender")
    private Set<Message> sentMessages;

    @OneToMany(mappedBy = "receiver")
    @JsonIgnoreProperties("receiver")
    private Set<Message> receivedMessages;

}
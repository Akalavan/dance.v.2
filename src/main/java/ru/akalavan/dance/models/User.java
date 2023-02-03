package ru.akalavan.dance.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Class Use
 *
 * @author Вагин Михаил
 * date 19.01.2023
 */
@Data
@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, unique = true, updatable = false)
    private String login;
    @Column(nullable = false, length = 3000)
    private String password;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    private String middleName;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String phone;

    @ManyToMany
    private Set<Role> roles = new HashSet<>();
    @OneToMany(mappedBy = "user")
    Set<GroupTrainer> groupTrainers = new HashSet<>();

    @JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss")
    @Column(updatable = false)
    private LocalDateTime createDate;

    @Transient
    private Collection<? extends GrantedAuthority> authorities;

    public User() {
    }

    public User(long id, String login, String password, String email,
                Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.authorities = authorities;
    }

    @PrePersist
    protected void onCreate() {
        this.createDate = LocalDateTime.now();
    }

    /**
     * SECURITY
     */

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

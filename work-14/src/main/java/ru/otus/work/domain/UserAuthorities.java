package ru.otus.work.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@Entity
@Table(name = "user_authorities")
public class UserAuthorities implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "authority")
    private String authority;

    public UserAuthorities() {
    }
}
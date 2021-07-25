package com.example.gfg.libraryapp.security;

import com.example.gfg.libraryapp.models.Student;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class User implements UserDetails {

    private static final String DELIMITER = ":";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne(mappedBy = "user")
    @JsonIgnoreProperties("user")
    private Student student;

    @Column(unique = true, nullable = false)
    private String username;

    private String password;
    private String authorities;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return Arrays.stream(this.authorities.split(DELIMITER))
                .map(auth -> new SimpleGrantedAuthority(auth))
                .collect(Collectors.toList());

    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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

package com.library.spring_boot_library.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users",
uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email")
})
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(max = 120)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleEntity> roles;

    public UserEntity(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public UserEntity() {
    }


    public Long getId() {
        return id;
    }

    public UserEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public @NotBlank @Size(max = 20) String getUsername() {
        return username;
    }

    public UserEntity setUsername(@NotBlank @Size(max = 20) String username) {
        this.username = username;
        return this;
    }

    public @NotBlank @Size(max = 50) @Email String getEmail() {
        return email;
    }

    public UserEntity setEmail(@NotBlank @Size(max = 50) @Email String email) {
        this.email = email;
        return this;
    }

    public @NotBlank @Size(max = 120) String getPassword() {
        return password;
    }

    public UserEntity setPassword(@NotBlank @Size(max = 120) String password) {
        this.password = password;
        return this;
    }

    public Set<RoleEntity> getRoles() {
        return roles;
    }

    public UserEntity setRoles(Set<RoleEntity> roles) {
        this.roles = new HashSet<>(roles);
        return this;
    }
}

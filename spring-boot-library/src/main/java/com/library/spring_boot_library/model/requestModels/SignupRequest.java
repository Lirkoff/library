package com.library.spring_boot_library.model.requestModels;

import com.library.spring_boot_library.model.validation.FieldMatch;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Set;

@FieldMatch(
        first = "password",
        second = "repeatPassword",
        message = "Passwords must be identical!"
)
public class SignupRequest {
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(min = 3, max = 20)
    private String username;

    private Set<String> roles;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    @NotBlank
    @Size(min = 6, max = 40)
    private String repeatPassword;


    public @NotBlank @Size(max = 50) @Email String getEmail() {
        return email;
    }

    public SignupRequest setEmail(@NotBlank @Size(max = 50) @Email String email) {
        this.email = email;
        return this;
    }

    public @NotBlank @Size(min = 3, max = 20) String getUsername() {
        return username;
    }

    public SignupRequest setUsername(@NotBlank @Size(min = 3, max = 20) String username) {
        this.username = username;
        return this;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public SignupRequest setRoles(Set<String> roles) {
        this.roles = roles;
        return this;
    }

    public @NotBlank @Size(min = 6, max = 40) String getPassword() {
        return password;
    }

    public SignupRequest setPassword(@NotBlank @Size(min = 6, max = 40) String password) {
        this.password = password;
        return this;
    }

    public @NotBlank @Size(min = 6, max = 40) String getRepeatPassword() {
        return repeatPassword;
    }

    public SignupRequest setRepeatPassword(@NotBlank @Size(min = 6, max = 40) String repeatPassword) {
        this.repeatPassword = repeatPassword;
        return this;
    }
}

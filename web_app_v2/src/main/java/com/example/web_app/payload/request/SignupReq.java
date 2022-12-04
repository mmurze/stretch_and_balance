package com.example.web_app.payload.request;

import com.example.web_app.entity.RoleEntity;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

public class SignupReq {
    @NotBlank(message = "Username cannot be null")
    @Size(min = 3, max = 30)
    @Email
    private String username;
    private Set<String> role;
    @NotBlank(message = "Password cannot be null")
    private String password;

    @NotNull(message = "Name cannot be null")
    @Size(max = 40)
    private String firstname;

    @NotNull(message = "Name cannot be null")
    @Size(max = 40)
    private String lastname;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<String> getRole() {
        return role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}

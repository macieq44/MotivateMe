package com.gmail.macieq44.motivateme.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

/**
 * Created by Macieq44 on 27.11.2017.
 */
@Entity(name = "UserInfo")
public class User extends AbstractEntity {

    @NotNull
    @Size(min = 1, max = 255)
    @Column(unique = true)
    private String email;

    @NotNull
    @Size(min = 4, max = 255)
    private String password;

    @NotNull
    @Size(min = 1, max = 255)
    private String name;

    @NotNull
    @Size(min = 1, max = 255)
    private String role;

    private boolean locked = false;

    public User() {}

    public User(String email, String name, String password, String role) {
        Objects.requireNonNull(email);
        Objects.requireNonNull(name);
        Objects.requireNonNull(password);
        Objects.requireNonNull(role);

        this.email = email;
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }
}

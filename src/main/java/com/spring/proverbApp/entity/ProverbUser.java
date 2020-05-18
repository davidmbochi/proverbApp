package com.spring.proverbApp.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Entity
@Table(name = "users")
public class ProverbUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull(message = "required")
    @Column(name = "username")
    private String username;

    @NotNull(message = "required")
    @Column(name = "password")
    private String password;

    @NotNull(message = "required")
    @Column(name = "first_name")
    private String firstName;

    @NotNull(message = "required")
    @Column(name = "last_name")
    private String lastName;

    @NotNull(message = "required")
    @Column(name = "email")
    private String email;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<UserRole> userRoles;

    public ProverbUser(){

    }

    public ProverbUser(@NotNull(message = "required") String username, @NotNull(message = "required") String password, @NotNull(message = "required") String firstName, @NotNull(message = "required") String lastName, @NotNull(message = "required") String email) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public ProverbUser(@NotNull(message = "required") String username, @NotNull(message = "required") String password, @NotNull(message = "required") String firstName, @NotNull(message = "required") String lastName, @NotNull(message = "required") String email, Collection<UserRole> userRoles) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userRoles = userRoles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Collection<UserRole> userRoles) {
        this.userRoles = userRoles;
    }
}

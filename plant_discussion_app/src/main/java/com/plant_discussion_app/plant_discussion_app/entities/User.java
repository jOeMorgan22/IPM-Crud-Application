package com.plant_discussion_app.plant_discussion_app.entities;




import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.plant_discussion_app.plant_discussion_app.validation.UserName;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    
    @NotEmpty(message = "Username cannot be empty")
    @NotBlank(message = "Username cannot be Blank")
    @Size(min = 5, max = 15, message = "Username must be 5-15 characters long")
    @UserName
    @Column(name = "usernames", nullable = false, length = 15, unique = true)
    private String username;

    @JsonIgnore
    @Column(name = "passwords")
    private String password;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Report> userPosts;
    
    public User(){

    }

    public User(String username, String password){
        this.username = username;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
   
    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
}

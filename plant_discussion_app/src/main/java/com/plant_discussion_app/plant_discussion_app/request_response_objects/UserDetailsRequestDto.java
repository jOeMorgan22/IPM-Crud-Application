package com.plant_discussion_app.plant_discussion_app.request_response_objects;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Component;

import com.plant_discussion_app.plant_discussion_app.validation.Password;
import com.plant_discussion_app.plant_discussion_app.validation.UserName;

@Component
public class UserDetailsRequestDto {
    
    @NotEmpty(message = "Username cannot be empty")
    @NotBlank(message = "Username cannot be Blank")
    @Size(min = 5, max = 15, message = "Username must be 5-15 characters long")
    @UserName
    private String username;

    @NotEmpty(message = "Password cannot be empty")
    @NotBlank(message = "Password cannot be blank")
    @Password
    private String password;

    public UserDetailsRequestDto(){
        
    }

    public UserDetailsRequestDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    
    
}

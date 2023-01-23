package com.plant_discussion_app.plant_discussion_app.request_response_objects;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsResponseDto {
    private Long id;
    private String username;

    

    public UserDetailsResponseDto(){

    }
    
    public UserDetailsResponseDto(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }    
    

}

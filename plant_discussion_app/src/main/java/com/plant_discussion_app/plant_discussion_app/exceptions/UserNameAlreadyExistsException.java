package com.plant_discussion_app.plant_discussion_app.exceptions;

public class UserNameAlreadyExistsException extends RuntimeException{

    public UserNameAlreadyExistsException(String username){
        super(String.format("Username '%s' is not available", username));
    }
    
}

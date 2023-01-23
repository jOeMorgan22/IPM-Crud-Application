package com.plant_discussion_app.plant_discussion_app.exceptions;

public class UserNameNotFoundException extends RuntimeException{

    public UserNameNotFoundException(String username){
        super(String.format("'%s' username was not found in our database", username));
    }
}

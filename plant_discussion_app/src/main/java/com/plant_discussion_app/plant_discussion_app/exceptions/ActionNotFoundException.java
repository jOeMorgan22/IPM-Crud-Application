package com.plant_discussion_app.plant_discussion_app.exceptions;

public class ActionNotFoundException extends RuntimeException{

    public ActionNotFoundException(Long id){
        super(String.format("Action '%d' not found", id));
    }
    
}

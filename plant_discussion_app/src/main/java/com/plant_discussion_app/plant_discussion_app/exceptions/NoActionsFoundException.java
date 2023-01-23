package com.plant_discussion_app.plant_discussion_app.exceptions;

public class NoActionsFoundException extends RuntimeException{

    public NoActionsFoundException(Long id){
        super(String.format("Report '%d' has no posted actions"));
    }
    
}

package com.plant_discussion_app.plant_discussion_app.exceptions;

public class NoReportsFoundException extends RuntimeException{

    public NoReportsFoundException(Long id){
        super(String.format("User '%d' has made no reports", id));
    }
    
}

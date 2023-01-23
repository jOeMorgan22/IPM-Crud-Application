package com.plant_discussion_app.plant_discussion_app.exceptions;

public class ReportNotFoundException extends RuntimeException {

    public ReportNotFoundException(Long id){
        super(String.format("Report '%d' was not found", id));
    }
    
}

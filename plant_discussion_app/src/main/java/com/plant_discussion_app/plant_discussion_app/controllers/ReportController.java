package com.plant_discussion_app.plant_discussion_app.controllers;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plant_discussion_app.plant_discussion_app.entities.Report;

@RestController
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    ReportControllerFunctions userPostControllerFunctions;
 
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Report>> getReportsByUserId(@PathVariable Long userId){
        return new ResponseEntity<>(userPostControllerFunctions.getAllReportsByUserId(userId), HttpStatus.OK);
    }

    @GetMapping("/{reportId}")
    public ResponseEntity<Report> getReportsById(@PathVariable Long reportId){
        return new ResponseEntity<>(userPostControllerFunctions.getReportById(reportId), HttpStatus.OK);
    }

    @PostMapping("/users/{userId}")
    public ResponseEntity<Report> createReport(@PathVariable Long userId, @Valid @RequestBody Report report){
        return new ResponseEntity<>(userPostControllerFunctions.createReport(userId, report), HttpStatus.CREATED);
    }

    @DeleteMapping("/{reportId}")
    public ResponseEntity<HttpStatus> deleteReportsById(@PathVariable Long reportId){
        userPostControllerFunctions.deleteReport(reportId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @DeleteMapping("/users/{userId}")
    public ResponseEntity<HttpStatus> deleteReportsByUserId(@PathVariable Long userId){
        userPostControllerFunctions.deleteReportsByUserId(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    
 
}

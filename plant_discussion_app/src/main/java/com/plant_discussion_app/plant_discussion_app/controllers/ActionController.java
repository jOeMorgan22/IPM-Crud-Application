package com.plant_discussion_app.plant_discussion_app.controllers;

import java.util.List;

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

import com.plant_discussion_app.plant_discussion_app.entities.Action;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/actions")
public class ActionController {
    
    @Autowired
    ActionControllerFunctions actionControllerFunctions;

    @GetMapping("/{actionId}")
    public ResponseEntity<Action> getPostActionById(@PathVariable Long actionId){
        return new ResponseEntity<>(actionControllerFunctions.getActionById(actionId), HttpStatus.OK);
    }

    @GetMapping("/reports/{reportId}")
    public ResponseEntity<List<Action>> getActionsByReportId(@PathVariable Long reportId){
        return new ResponseEntity<>(actionControllerFunctions.getActionsByReportId(reportId), HttpStatus.OK);
    }

    @PostMapping("/reports/{reportId}")
    public ResponseEntity<Action> createAction(@PathVariable Long reportId, @Valid @RequestBody Action actionDetails){
        return new ResponseEntity<>(actionControllerFunctions.createAction(reportId, actionDetails), HttpStatus.CREATED);
    }

    @DeleteMapping("/{actionId}")
    public ResponseEntity<HttpStatus> deleteActionById(@PathVariable Long actionId){
        actionControllerFunctions.deletePostAction(actionId);
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }
}

package com.plant_discussion_app.plant_discussion_app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.plant_discussion_app.plant_discussion_app.entities.Action;
import com.plant_discussion_app.plant_discussion_app.services.ActionServiceImpl;

@Component
public class ActionControllerFunctions {
    
    @Autowired
    ActionServiceImpl actionService;

    public Action createAction(Long postId, Action postAction){
        return actionService.createAction(postId, postAction);
    }

    public List<Action> getActionsByReportId(Long postId){
        return actionService.getActionsByReportId(postId);
    }

    public Action getActionById(Long id){
        return actionService.getAction(id);
    }

    public void deletePostAction(Long id){
        actionService.deleteAction(id);
    }

}

package com.plant_discussion_app.plant_discussion_app.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.plant_discussion_app.plant_discussion_app.entities.Action;
import com.plant_discussion_app.plant_discussion_app.exceptions.NoActionsFoundException;
import com.plant_discussion_app.plant_discussion_app.exceptions.ActionNotFoundException;
import com.plant_discussion_app.plant_discussion_app.exceptions.ReportNotFoundException;
import com.plant_discussion_app.plant_discussion_app.repositories.ActionRepository;

@Service
public class ActionServiceImpl implements ActionService{

    @Autowired
    ActionRepository actionRepository;
    
    @Autowired
    ReportServiceImpl reportService;

    @Override
    public Action createAction(Long reportId, Action actionDetails) {
        try{
            actionDetails.setReport(reportService.getReportById(reportId));
            actionDetails.setTimeStamp(LocalDateTime.now());
            actionRepository.save(actionDetails);
        }catch(ReportNotFoundException ex){
            throw new ReportNotFoundException(reportId);
        }
        return actionDetails;
    }

    @Override
    public void deleteAction(Long id) throws DataIntegrityViolationException{
        actionRepository.deleteById(id);
        
    }

    @Override
    public Action getAction(Long id) {
        Optional<Action> action = actionRepository.findById(id);
        if(action.isPresent()){
            return action.get();
        }else{
            throw new ActionNotFoundException(id);
        }
    }

    @Override
    public List<Action> getActionsByReportId(Long id) {
        try{
        List<Action> userPostActions = actionRepository.findActionsByReportId(id);
        if(userPostActions.isEmpty()){
            throw new NoActionsFoundException(id);
        }
        return userPostActions;
        }catch(ReportNotFoundException ex){
            throw new ReportNotFoundException(id);
        }
    }
    
}

package com.plant_discussion_app.plant_discussion_app.services;

import java.util.List;

import com.plant_discussion_app.plant_discussion_app.entities.Action;

public interface ActionService {
    Action createAction(Long id, Action postAction);
    Action getAction(Long id);
    List<Action> getActionsByReportId(Long id);
    void deleteAction(Long id);
}

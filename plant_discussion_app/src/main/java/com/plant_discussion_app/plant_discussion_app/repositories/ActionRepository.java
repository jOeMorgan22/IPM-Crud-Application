package com.plant_discussion_app.plant_discussion_app.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.plant_discussion_app.plant_discussion_app.entities.Action;

public interface ActionRepository extends CrudRepository<Action, Long>{
    
    List<Action> findActionsByReportId(Long id);
}

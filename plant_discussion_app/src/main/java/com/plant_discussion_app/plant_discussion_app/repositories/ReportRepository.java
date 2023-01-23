package com.plant_discussion_app.plant_discussion_app.repositories;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

import com.plant_discussion_app.plant_discussion_app.entities.Report;

public interface ReportRepository extends CrudRepository<Report, Long>{
    
    List<Report> findReportsByUserId(Long id);

}

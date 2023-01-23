package com.plant_discussion_app.plant_discussion_app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.plant_discussion_app.plant_discussion_app.entities.Report;
import com.plant_discussion_app.plant_discussion_app.services.ReportServiceImpl;


@Component
public class ReportControllerFunctions {
    
    @Autowired
    ReportServiceImpl reportService;

    public Report createReport(Long userId, Report report){
        return reportService.createReport(userId, report);
    }

    public List<Report> getAllReportsByUserId(Long userId){
        return reportService.getReportsByUserId(userId);
    }

    public Report getReportById(Long id){
        return reportService.getReportById(id);
    }

    public void deleteReport(Long id){
        reportService.deleteReport(id);
    }

    public void deleteReportsByUserId(Long UserId){
        reportService.deleteAllReportsByUserId(UserId);
    }

}

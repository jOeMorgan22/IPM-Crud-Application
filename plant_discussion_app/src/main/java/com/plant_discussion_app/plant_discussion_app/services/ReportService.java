package com.plant_discussion_app.plant_discussion_app.services;

import java.util.List;

import com.plant_discussion_app.plant_discussion_app.entities.Report;

public interface ReportService {
    Report getReportById(Long id);
    Report createReport(Long userId, Report postDetails);
    List<Report> getReportsByUserId(Long userId);
    void deleteReport(Long id);
    void deleteAllReportsByUserId(Long userId);
}

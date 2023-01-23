package com.plant_discussion_app.plant_discussion_app.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import com.plant_discussion_app.plant_discussion_app.entities.Report;
import com.plant_discussion_app.plant_discussion_app.exceptions.NoReportsFoundException;
import com.plant_discussion_app.plant_discussion_app.exceptions.UserNotFoundException;
import com.plant_discussion_app.plant_discussion_app.exceptions.ReportNotFoundException;
import com.plant_discussion_app.plant_discussion_app.repositories.ReportRepository;

@Service
public class ReportServiceImpl implements ReportService{

   
    private UserServiceImpl userService;
    
    private ReportRepository reportRepository;

    public ReportServiceImpl(UserServiceImpl userService, ReportRepository reportRepository) {
        this.userService = userService;
        this.reportRepository = reportRepository;
    }

    @Override
    public Report createReport(Long userId, Report reportDetails) {
      try{
        reportDetails.setUser(userService.getUserById(userId));
        reportDetails.setTimeStamp(LocalDateTime.now());
        reportRepository.save(reportDetails);
      }catch(UserNotFoundException ex){
        throw new UserNotFoundException(userId);
      }
        return reportDetails;
    }

    @Override
    public List<Report> getReportsByUserId(Long userId){
        try{
        List<Report> userPosts = reportRepository.findReportsByUserId(userId);
        if(userPosts.isEmpty()){
            throw new NoReportsFoundException(userId);
        }
            return userPosts;
        
        } catch(UserNotFoundException ex){
            throw new UserNotFoundException(userId);
        }
    }

    @Override
    public Report getReportById(Long id) {
         Optional<Report> userPost = reportRepository.findById(id);
         if(userPost.isPresent()){
            return userPost.get();
         }else{
            throw new ReportNotFoundException(id);
         }
    }

    @Override
    public void deleteReport(Long id) throws DataIntegrityViolationException{
        reportRepository.deleteById(id);
        
    }

    @Override
    public void deleteAllReportsByUserId(Long userId) throws UserNotFoundException, DataIntegrityViolationException {
        try{
        for(Report userPost : getReportsByUserId(userId)){
            reportRepository.delete(userPost);
        }
        }catch(UserNotFoundException ex){
            throw new UserNotFoundException(userId);
        }
    }


    


    
    
}

package com.plant_discussion_app.plant_discussion_app.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;



@Entity
@Table(name= "Actions")
public class Action {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @NotBlank(message = "Action title may not be blank")
    @NotEmpty(message = "Action title may not be empty")
    @Size(max = 50, message = "Action title cannot be more than 50 characters")
    @Column(name = "actionTitles")
    private String actionTitle;

    @NotBlank(message = "Action ontents may not be blank")
    @NotEmpty(message = "Action contents may not be empty")
    @Size(max = 500, message = "Action contents cannot be more than 500 characters")
    @Column(name = "actionContents")
    private String actionContents;

    @PastOrPresent
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "timeStamps")
    private LocalDateTime timeStamp;

    @ManyToOne(optional = false)
    @JoinColumn(name = "report_id", referencedColumnName = "id")
    public Report report;

    public Action(){

    }

    public String getActionTitle() {
        return actionTitle;
    }

    public void setActionTitle(String actionTitle) {
        this.actionTitle = actionTitle;
    }

    public String getActionContents() {
        return actionContents;
    }

    public void setActionContents(String actionContents) {
        this.actionContents = actionContents;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}

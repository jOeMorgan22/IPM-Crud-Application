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
@Table(name = "reports")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @PastOrPresent
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "timeStamps")
    private LocalDateTime timeStamp;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(name = "reportTitles")
    @Size(max = 50, message = "Report title cannot be more than 50 charactes")
    @NotBlank(message = "Report title cannot be blank")
    @NotEmpty(message = "Report title cannot be empty")
    private String reportTitle;

    @Column(name = "reportContents")
    @Size(max = 500, message = "Reports limited to 500 characters")
    @NotEmpty(message = "Report cannot be empty")
    @NotBlank(message = "Report cannot be blank")
    private String reportContent;

    public Report() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getReportContent() {
        return reportContent;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }

    public String getReportTitle() {
        return reportTitle;
    }

    public void setReportTitle(String reportTitle) {
        this.reportTitle = reportTitle;
    }   
    
}

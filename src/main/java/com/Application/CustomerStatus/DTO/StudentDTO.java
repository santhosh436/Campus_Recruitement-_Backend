package com.Application.CustomerStatus.DTO;

import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

public class StudentDTO {
    private String email;
    private String password;
    private LocalDate dateOfBirth;
    private Integer sscYearOfPassing;
    private Float sscPercentage;
    private Integer intermediateYearOfPassing;
    private Float intermediatePercentage;
    private String bTechStream;
    private Float bTechPercentage;
    private Integer numberOfBacklogs;


    // Getters and Setters

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getSscYearOfPassing() {
        return sscYearOfPassing;
    }

    public void setSscYearOfPassing(Integer sscYearOfPassing) {
        this.sscYearOfPassing = sscYearOfPassing;
    }

    public Float getSscPercentage() {
        return sscPercentage;
    }

    public void setSscPercentage(Float sscPercentage) {
        this.sscPercentage = sscPercentage;
    }

    public Integer getIntermediateYearOfPassing() {
        return intermediateYearOfPassing;
    }

    public void setIntermediateYearOfPassing(Integer intermediateYearOfPassing) {
        this.intermediateYearOfPassing = intermediateYearOfPassing;
    }

    public Float getIntermediatePercentage() {
        return intermediatePercentage;
    }

    public void setIntermediatePercentage(Float intermediatePercentage) {
        this.intermediatePercentage = intermediatePercentage;
    }

    public String getbTechStream() {
        return bTechStream;
    }

    public void setbTechStream(String bTechStream) {
        this.bTechStream = bTechStream;
    }

    public Float getbTechPercentage() {
        return bTechPercentage;
    }

    public void setbTechPercentage(Float bTechPercentage) {
        this.bTechPercentage = bTechPercentage;
    }

    public Integer getNumberOfBacklogs() {
        return numberOfBacklogs;
    }

    public void setNumberOfBacklogs(Integer numberOfBacklogs) {
        this.numberOfBacklogs = numberOfBacklogs;
    }

}



package com.Application.CustomerStatus.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
    @SequenceGenerator(name = "student_seq", sequenceName = "student_sequence", allocationSize = 1)
    private Long id;

    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    private LocalDate dateOfBirth;

    @NotNull
    private Integer sscYearOfPassing;

    @NotNull
    private Float sscPercentage;

    @NotNull
    private Integer intermediateYearOfPassing;

    @NotNull
    private Float intermediatePercentage;

    @NotNull
    private String bTechStream;

    @NotNull
    private Float bTechPercentage;

    @NotNull
    private Integer numberOfBacklogs;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

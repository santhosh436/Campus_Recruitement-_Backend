package com.Application.CustomerStatus.Model;

import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;
import java.util.List;

@Entity
@Table(name = "job_posts")
public class CompanyJobPost {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "job_post_seq")
    @SequenceGenerator(name = "job_post_seq", sequenceName = "job_post_sequence", allocationSize = 1)
    private Long id;

    private String companyName;
    private String jobTitle;
    private Integer companyId;

    @Type(JsonType.class)
    @Column(name = "responsibilities", columnDefinition = "jsonb")
    private List<String> responsibilities;

    @Type(JsonType.class)
    @Column(name = "requirements", columnDefinition = "jsonb")
    private List<String> requirements;

    // Newly added attributes
    private String type; // onsite, remote, hybrid, work from home
    private String location; // country name
    private String salary; // salary as string

    // Constructors, Getters, and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public List<String> getResponsibilities() {
        return responsibilities;
    }

    public void setResponsibilities(List<String> responsibilities) {
        this.responsibilities = responsibilities;
    }

    public List<String> getRequirements() {
        return requirements;
    }

    public void setRequirements(List<String> requirements) {
        this.requirements = requirements;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}

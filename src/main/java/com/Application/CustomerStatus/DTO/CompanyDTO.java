package com.Application.CustomerStatus.DTO;

public class CompanyDTO {

    private String companyName;   // Company's full name
    private String established;   // Established date in string (format: yyyy-MM-dd)
    private String hrName;        // HR representative's name
    private String email;         // Company email
    private Long contactNo;     // Contact number of the company (as a string for flexibility)
    private Long yourId;        // Company's unique ID (can be an internal reference)
    private String username;      // Username for login
    private String password;      // Password for login

    // Getters and Setters for all the fields

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getEstablished() {
        return established;
    }

    public void setEstablished(String established) {
        this.established = established;
    }

    public String getHrName() {
        return hrName;
    }

    public void setHrName(String hrName) {
        this.hrName = hrName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getContactNo() {
        return contactNo;
    }

    public void setContactNo(Long contactNo) {
        this.contactNo = contactNo;
    }

    public Long getYourId() {
        return yourId;
    }

    public void setYourId(Long yourId) {
        this.yourId = yourId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

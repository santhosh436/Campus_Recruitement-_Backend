package com.Application.CustomerStatus.Service;

import com.Application.CustomerStatus.DTO.CompanyDTO;
import com.Application.CustomerStatus.Model.Company;
import com.Application.CustomerStatus.Repository.CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    CompanyRepo companyRepo;

    public String companyRegister(CompanyDTO companyDTO) {

        // Check if a company with the given email already exists
        Optional<Company> existingUser = companyRepo.findCompanyUserByEmail(companyDTO.getEmail());
        if (existingUser.isPresent()) {
            return "You are already registered.";
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate establishedDate;

        try {
            // Parse the established date from the string format to LocalDate
            establishedDate = LocalDate.parse(companyDTO.getEstablished(), formatter);
        } catch (DateTimeParseException e) {
            return "Invalid established date format. Please use 'dd-MM-yyyy'.";
        }
        // Map the CompanyDTO fields to the Company entity
        Company newCompanyUser = new Company();
        newCompanyUser.setUsername(companyDTO.getUsername());
        newCompanyUser.setCompanyName(companyDTO.getCompanyName());  // Update to use the correct field
        newCompanyUser.setEstablished(establishedDate);  // Add established date
        newCompanyUser.setHrName(companyDTO.getHrName());            // Add HR name
        newCompanyUser.setContactNo(companyDTO.getContactNo());      // Add contact number
        newCompanyUser.setYourId(companyDTO.getYourId());            // Add your ID (company ID)
        newCompanyUser.setEmail(companyDTO.getEmail());
        newCompanyUser.setPassword(companyDTO.getPassword());

        // Save the new company user to the database
        companyRepo.save(newCompanyUser);

        return "You have successfully registered.";
    }


    public Map<String, Object> CompanyLogin(String username, String password) {
        // Fetch the company based on username and password
        Company company = companyRepo.findByUsernameAndPassword(username, password);

        if (company != null) {
            // Prepare a success response with company ID
            Map<String, Object> loginResponse = new HashMap<>();
            loginResponse.put("message", "Logined Successfully");
            loginResponse.put("companyId", company.getYourId());  // Add company ID to the response
            return loginResponse;
        } else {
            // Prepare a failure response
            Map<String, Object> failureResponse = new HashMap<>();
            failureResponse.put("message", "Login failed");
            return failureResponse;
        }
    }

}

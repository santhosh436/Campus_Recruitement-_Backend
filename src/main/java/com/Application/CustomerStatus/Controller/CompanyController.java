package com.Application.CustomerStatus.Controller;

import com.Application.CustomerStatus.DTO.CompanyDTO;
import com.Application.CustomerStatus.Service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("company")
@CrossOrigin(origins = "http://localhost:3000/")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @PostMapping("register")
    public ResponseEntity<Map<String, Object>> companyRegistration(@RequestBody CompanyDTO companyDTO) {
        String result = companyService.companyRegister(companyDTO);  // Call the service method

        Map<String, Object> response = new HashMap<>();

        // Match the exact success message from the service
        if ("You have successfully registered.".equals(result)) {
            response.put("message", "Registration successful");
            return ResponseEntity.ok(response);  // Return JSON with HTTP 200 status
        } else {
            response.put("message", result);  // Send back the error message returned by the service
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);  // Return with 400 status
        }
    }


    @PostMapping("login")
    public ResponseEntity<Map<String, Object>> CompanyLogin(@RequestBody CompanyDTO companyDTO) {
        Map<String, Object> loginResult = companyService.CompanyLogin(companyDTO.getUsername(), companyDTO.getPassword());

        if ("Logined Successfully".equals(loginResult.get("message"))) {
            // Return success with company ID
            return ResponseEntity.ok(loginResult);
        } else {
            // Return failure message
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(loginResult);
        }
    }


}

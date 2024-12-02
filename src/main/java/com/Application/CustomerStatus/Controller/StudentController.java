package com.Application.CustomerStatus.Controller;


import com.Application.CustomerStatus.DTO.StudentDTO;
import com.Application.CustomerStatus.DTO.StudentLoginDTO;
import com.Application.CustomerStatus.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/register")
    public ResponseEntity<String> registerStudent(@RequestBody StudentDTO studentDTO) {
        try {
            studentService.registerStudent(studentDTO);
            return ResponseEntity.ok("Student registered successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginStudent(@RequestBody StudentLoginDTO studentLoginDTO) {
        try {
            studentService.loginStudent(studentLoginDTO.getEmail(), studentLoginDTO.getPassword());
            return ResponseEntity.ok("Login successful");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

}

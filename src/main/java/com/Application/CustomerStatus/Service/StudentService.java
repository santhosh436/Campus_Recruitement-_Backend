package com.Application.CustomerStatus.Service;

import com.Application.CustomerStatus.DTO.StudentDTO;
import com.Application.CustomerStatus.DTO.StudentLoginDTO;
import com.Application.CustomerStatus.Model.Student;
import com.Application.CustomerStatus.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;


    public Student registerStudent(StudentDTO studentDTO) throws IOException {
        Student student = new Student();

        student.setEmail(studentDTO.getEmail());
        student.setPassword(studentDTO.getPassword()); // Add password encoding
        student.setDateOfBirth(studentDTO.getDateOfBirth());
        student.setSscYearOfPassing(studentDTO.getSscYearOfPassing());
        student.setSscPercentage(studentDTO.getSscPercentage());
        student.setIntermediateYearOfPassing(studentDTO.getIntermediateYearOfPassing());
        student.setIntermediatePercentage(studentDTO.getIntermediatePercentage());
        student.setbTechStream(studentDTO.getbTechStream());
        student.setbTechPercentage(studentDTO.getbTechPercentage());
        student.setNumberOfBacklogs(studentDTO.getNumberOfBacklogs());
         // Convert file to bytes

        return studentRepo.save(student);
    }

    public Student loginStudent(String email,String password) {
        Optional<Student> student = studentRepo.findByEmail(email);
        if (student.isPresent() && student.get().getPassword().equals(password)) {
            return student.get();
        }
        throw new RuntimeException("Invalid credentials");
    }
}

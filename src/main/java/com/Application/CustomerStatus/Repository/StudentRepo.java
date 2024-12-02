package com.Application.CustomerStatus.Repository;

import com.Application.CustomerStatus.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepo extends JpaRepository<Student,Long> {

    Optional<Student> findByEmail(String email);
}

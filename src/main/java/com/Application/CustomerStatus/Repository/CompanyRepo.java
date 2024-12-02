package com.Application.CustomerStatus.Repository;

import com.Application.CustomerStatus.Model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepo extends JpaRepository<Company,Long> {

    Optional<Company> findCompanyUserByEmail(String email);

    Optional<Company> findCompanyUserByUsername(String username);

    Company findByUsernameAndPassword(String username, String password);
}

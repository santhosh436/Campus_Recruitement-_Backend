package com.Application.CustomerStatus.Repository;

import com.Application.CustomerStatus.Model.CompanyJobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CompanyJobPostRepo extends JpaRepository<CompanyJobPost, Long> {

    @Query("SELECT MAX(c.id) FROM CompanyJobPost c")
    Optional<Long> findMaxId();

    List<CompanyJobPost> findByCompanyId(Integer companyId);
}


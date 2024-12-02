package com.Application.CustomerStatus.Service;

import com.Application.CustomerStatus.Model.CompanyJobPost;
import com.Application.CustomerStatus.Repository.CompanyJobPostRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyJobPostService {

    @Autowired
    private CompanyJobPostRepo companyJobPostRepo;

    @Transactional
    public CompanyJobPost createJobPost(String jobTitle, String companyName, Integer companyId, List<String> responsibilities, List<String> requirements, String type, String location, String salary) {
        CompanyJobPost jobPost = new CompanyJobPost();
        jobPost.setJobTitle(jobTitle);
        jobPost.setCompanyName(companyName);
        jobPost.setCompanyId(companyId);
        jobPost.setResponsibilities(responsibilities);
        jobPost.setRequirements(requirements);
        jobPost.setType(type);
        jobPost.setLocation(location);
        jobPost.setSalary(salary);
        Optional<Long> maxId = companyJobPostRepo.findMaxId();
        jobPost.setId((long) (maxId.orElse(0L)+1));
        try {
            return companyJobPostRepo.save(jobPost);
        } catch (Exception e) {
            // Log exception details
            throw new RuntimeException("Failed to save job post. Transaction rolled back.");
        }
    }

    public List<CompanyJobPost> getAllJobPosts() {
        return companyJobPostRepo.findAll();
    }


    public List<CompanyJobPost> getJobPostsByCompanyId(Integer companyId) {
        return companyJobPostRepo.findByCompanyId(companyId);
    }

    public void deleteJobPost(Long id) {
        companyJobPostRepo.deleteById(id);
    }
}

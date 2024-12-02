package com.Application.CustomerStatus.Controller;

import com.Application.CustomerStatus.DTO.CompanyJobPostDTO;
import com.Application.CustomerStatus.Model.CompanyJobPost;
import com.Application.CustomerStatus.Service.CompanyJobPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("jobs")
@CrossOrigin
public class CompanyJobPostController {

    @Autowired
    private CompanyJobPostService companyJobPostService;

    @PostMapping("/create")
    public ResponseEntity<CompanyJobPost> createJobPost(@RequestBody CompanyJobPostDTO companyJobPostDTO) {
        CompanyJobPost companyJobPost = companyJobPostService.createJobPost(
                companyJobPostDTO.getJobTitle(),
                companyJobPostDTO.getCompanyName(),
                companyJobPostDTO.getCompanyId(),
                companyJobPostDTO.getResponsibilities(),
                companyJobPostDTO.getRequirements(),
                companyJobPostDTO.getType(),
                companyJobPostDTO.getLocation(),
                companyJobPostDTO.getSalary()
        );
        return ResponseEntity.ok(companyJobPost);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CompanyJobPost>> getAllJobPosts() {
        return ResponseEntity.ok(companyJobPostService.getAllJobPosts());
    }

    @GetMapping("/{companyId}")
    public ResponseEntity<List<CompanyJobPost>> getJobPostsByCompanyId(@PathVariable Integer companyId) {
        List<CompanyJobPost> jobPosts = companyJobPostService.getJobPostsByCompanyId(companyId);
        return ResponseEntity.ok(jobPosts);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteJobPost(@PathVariable Long id) {
        companyJobPostService.deleteJobPost(id);
        return ResponseEntity.noContent().build();
    }
}

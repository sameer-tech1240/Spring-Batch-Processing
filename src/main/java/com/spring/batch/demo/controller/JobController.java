package com.spring.batch.demo.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("jobs")
public class JobController {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job job;

    @PostMapping("/importCustomers")
    public ResponseEntity<String> importCsvToDBJob() {
        try {
            jobLauncher.run(job, new JobParametersBuilder().addLong("startAt", System.currentTimeMillis()).toJobParameters());
            return ResponseEntity.ok("Data inserted successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Job execution failed: " + e.getMessage());
        }
    }
}

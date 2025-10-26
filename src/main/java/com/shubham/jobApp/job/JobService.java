package com.shubham.jobApp.job;


import java.util.List;

public interface JobService {

    List<Job> findAll();
    String addJob(Job job);
    Job getJobById(Long id);
    boolean deleteJobById(Long id);

    boolean updateJobById(Long id, Job job);
}

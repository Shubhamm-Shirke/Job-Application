package com.shubham.jobApp.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;


@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository jobRepo;

    @Override
    public List<Job> findAll() {
        return jobRepo.findAll();
    }

    @Override
    public String addJob(Job job) {
        jobRepo.save(job);
        return "Job Added successfully.";
    }

    @Override
    public Job getJobById(Long id) {

        Optional<Job> job = jobRepo.findById(id);
        if (job.isPresent()) {
            return job.get();
        }
        return null;
    }

    @Override
    public boolean deleteJobById(Long id) {
        Optional<Job> job = jobRepo.findById(id);
        if (job.isPresent()) {
            jobRepo.delete(job.get());
            return  true;
        }
        return false;
    }

    @Override
    public boolean updateJobById(Long id, Job job) {
        Optional<Job> job2 = jobRepo.findById(id);
        if (job2.isPresent()) {
            Job existingJob = job2.get();
                existingJob.setDescription(job.getDescription());
                existingJob.setLocation(job.getLocation());
                existingJob.setTitle(job.getTitle());
                existingJob.setMaxSalary(job.getMaxSalary());
                existingJob.setMinSalary(job.getMinSalary());
                jobRepo.save(existingJob);
                return true;
        }
        return false;
    }

}

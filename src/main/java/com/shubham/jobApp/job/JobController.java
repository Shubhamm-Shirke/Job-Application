package com.shubham.jobApp.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping("/findalljobs")
    public ResponseEntity<List<Job>> findAll(){
        List<Job> jobList =  jobService.findAll();
        if (jobList != null) {
            return new ResponseEntity<>(jobList,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addjob")
    public ResponseEntity<String> addJob(@RequestBody Job job){
        String result = jobService.addJob(job);
        return new ResponseEntity<>(result,HttpStatus.CREATED);
    }

    @GetMapping("/getjob/{id}")
    public ResponseEntity<Job> getJob(@PathVariable Long id){
        Job job =  jobService.getJobById(id);
        if (job != null) {
            return new ResponseEntity<>(job, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deletejob/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id){
        boolean isDeleted = jobService.deleteJobById(id);
        if (isDeleted){
            return new ResponseEntity<>("Job deleted successfully",HttpStatus.OK);
        }else {
            return new ResponseEntity<>("failed to deleted job",HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateJob/{id}")
    public ResponseEntity<String> updateJob(@PathVariable Long id, @RequestBody Job job){
        boolean isUpdated = jobService.updateJobById(id,job);
        if (isUpdated){
            return new ResponseEntity<>("Job updated successfully",HttpStatus.OK);
        }else {
            return new ResponseEntity<>("failed to update job",HttpStatus.NOT_FOUND);
        }
    }

}

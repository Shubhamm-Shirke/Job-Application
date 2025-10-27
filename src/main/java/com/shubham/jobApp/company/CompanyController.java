package com.shubham.jobApp.company;

import com.shubham.jobApp.job.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/findallcompany")
    public ResponseEntity<List<Company>> findAll(){
        List<Company> companyList =  companyService.findAll();
        if (companyList != null) {
            return new ResponseEntity<>(companyList, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addcompany")
    public ResponseEntity<String> addcompany(@RequestBody Company company){
        String result = companyService.addCompany(company);
        return new ResponseEntity<>(result,HttpStatus.CREATED);
    }

    @GetMapping("/getcompany/{id}")
    public ResponseEntity<Company> getCompany(@PathVariable Long id){
        Company company =  companyService.getCompanyById(id);
        if (company != null) {
            return new ResponseEntity<>(company, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deletecompany/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id){
        boolean isDeleted = companyService.deleteCompanyById(id);
        if (isDeleted){
            return new ResponseEntity<>("Company deleted successfully",HttpStatus.OK);
        }else {
            return new ResponseEntity<>("failed to deleted company",HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updatecompany/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id, @RequestBody Company company){
        boolean isUpdated = companyService.updateCompanyById(id,company);
        if (isUpdated){
            return new ResponseEntity<>("Company updated successfully",HttpStatus.OK);
        }else {
            return new ResponseEntity<>("failed to update Company",HttpStatus.NOT_FOUND);
        }
    }

}

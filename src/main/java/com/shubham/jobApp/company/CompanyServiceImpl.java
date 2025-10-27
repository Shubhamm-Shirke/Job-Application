package com.shubham.jobApp.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService{

    @Autowired
    private CompanyRepository companyRepo;
    @Override
    public List<Company> findAll() {
        return companyRepo.findAll();
    }

    @Override
    public String addCompany(Company company) {
        companyRepo.save(company);
        return "Company Added successfully.";
    }

    @Override
    public Company getCompanyById(Long id) {
        Optional<Company> company = companyRepo.findById(id);
        if (company.isPresent()) {
            return company.get();
        }
        return null;
    }

    @Override
    public boolean deleteCompanyById(Long id) {
        Optional<Company> company = companyRepo.findById(id);
        if (company.isPresent()) {
            companyRepo.delete(company.get());
            return  true;
        }
        return false;
    }

    @Override
    public boolean updateCompanyById(Long id, Company company) {
        Optional<Company> company2 = companyRepo.findById(id);
        if (company2.isPresent()) {
            Company existingCompany = company2.get();
            existingCompany.setDescription(company.getDescription());
            existingCompany.setName(company.getName());
            existingCompany.setJobs(company.getJobs());
            companyRepo.save(existingCompany);
            return true;
        }
        return false;
    }
}

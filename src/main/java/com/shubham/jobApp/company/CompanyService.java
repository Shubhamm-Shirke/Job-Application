package com.shubham.jobApp.company;

import java.util.List;

public interface CompanyService {

    List<Company> findAll();
    String addCompany(Company company);
    Company getCompanyById(Long id);
    boolean deleteCompanyById(Long id);

    boolean updateCompanyById(Long id, Company company);
}

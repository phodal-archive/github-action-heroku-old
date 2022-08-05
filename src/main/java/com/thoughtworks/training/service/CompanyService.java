package com.thoughtworks.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private com.thoughtworks.training.repository.CompanyRepository companyRepository;

    public List<com.thoughtworks.training.model.Employee> getEmployeesByCompanyId(Integer companyId) {
        com.thoughtworks.training.model.Company company = companyRepository.findById(companyId).orElse(null);
        return company.getEmployees();
    }
}

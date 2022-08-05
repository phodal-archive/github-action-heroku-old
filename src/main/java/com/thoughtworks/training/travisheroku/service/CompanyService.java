package com.thoughtworks.training.travisheroku.service;

import com.thoughtworks.training.travisheroku.model.Company;
import com.thoughtworks.training.travisheroku.model.Employee;
import com.thoughtworks.training.travisheroku.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public List<Employee> getEmployeesByCompanyId(Integer companyId) {
        Company company = companyRepository.findById(companyId).orElse(null);
        return company.getEmployees();
    }
}

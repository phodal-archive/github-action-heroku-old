package com.thoughtworks.training.controller.mapper;

import com.thoughtworks.training.controller.dto.CompanyRequest;
import com.thoughtworks.training.controller.dto.CompanyResponse;
import com.thoughtworks.training.model.Company;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapper {
    public CompanyResponse toResponse(Company company) {
        CompanyResponse response = new CompanyResponse();

        response.setCompanyName(company.getCompanyName());
        response.setId(company.getId());
        response.setEmployees(company.getEmployees());
        response.setEmployeeNumber(company.getEmployees().size());

        return response;
    }

    public Company toEntity(CompanyRequest companyRequest) {
        Company company = new Company();
        company.setCompanyName(companyRequest.getCompanyName());
        return company;
    }
}

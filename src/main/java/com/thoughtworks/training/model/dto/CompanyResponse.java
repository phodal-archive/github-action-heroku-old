package com.thoughtworks.training.model.dto;

import com.thoughtworks.training.model.entity.Employee;

import java.util.List;

public class CompanyResponse {
    private Integer id;
    private String companyName;
    private Integer employeeNumber;
    private List<Employee> employees;

    public CompanyResponse() {
    }

    public CompanyResponse(Integer id, String companyName, Integer employeeNumber, List<Employee> employees) {
        this.id = id;
        this.companyName = companyName;
        this.employeeNumber = employeeNumber;
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(Integer employeeNumber) {
        this.employeeNumber = employeeNumber;
    }
}

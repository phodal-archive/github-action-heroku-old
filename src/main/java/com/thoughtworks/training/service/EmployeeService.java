package com.thoughtworks.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private com.thoughtworks.training.repository.EmployeeRepository employeeRepository;

    public List<com.thoughtworks.training.model.Employee> getEmployeesByPagination(Integer pageIndex, Integer pageSize) {
        return employeeRepository.findAll(PageRequest.of(pageIndex - 1, pageSize)).getContent();
    }

    public List<com.thoughtworks.training.model.Employee> getEmployeesByAgeArrange(Integer minAge, Integer maxAge) {
        return employeeRepository.findAllByAgeBetween(minAge, maxAge);
    }

    public void addEmployee(com.thoughtworks.training.model.Employee employee) {
        employeeRepository.save(employee);
    }
}

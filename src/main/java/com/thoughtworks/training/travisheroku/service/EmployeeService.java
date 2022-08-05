package com.thoughtworks.training.travisheroku.service;

import com.thoughtworks.training.travisheroku.model.Employee;
import com.thoughtworks.training.travisheroku.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployeesByPagination(Integer pageIndex, Integer pageSize) {
        return employeeRepository.findAll(PageRequest.of(pageIndex - 1, pageSize)).getContent();
    }

    public List<Employee> getEmployeesByAgeArrange(Integer minAge, Integer maxAge) {
        return employeeRepository.findAllByAgeBetween(minAge, maxAge);
    }

    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
}

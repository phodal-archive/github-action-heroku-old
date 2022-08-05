package com.thoughtworks.training.travisheroku.controller;

import com.thoughtworks.training.travisheroku.model.Employee;
import com.thoughtworks.training.travisheroku.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeesController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping(params = {"pageIndex", "pageSize"})
    public List<Employee> getEmployeesByPagination(@RequestParam Integer pageIndex, @RequestParam Integer pageSize) {
        return employeeService.getEmployeesByPagination(pageIndex, pageSize);
    }

    @GetMapping(params = {"minAge", "maxAge"})
    public List<Employee> getEmployeesByAgeArrange(@RequestParam Integer minAge, @RequestParam Integer maxAge) {
        return employeeService.getEmployeesByAgeArrange(minAge, maxAge);
    }

    @PostMapping
    public void addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }

}

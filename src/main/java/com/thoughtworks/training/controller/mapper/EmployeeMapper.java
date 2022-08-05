package com.thoughtworks.training.controller.mapper;

import com.thoughtworks.training.controller.dto.EmployeeRequest;
import com.thoughtworks.training.controller.dto.EmployeeResponse;
import com.thoughtworks.training.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {
    public EmployeeResponse toResponse(Employee employee) {
        EmployeeResponse response = new EmployeeResponse();

        // Manually
        response.setAge(employee.getAge());
        response.setCompanyId(employee.getCompanyId());
        response.setGender(employee.getGender());
        response.setId(employee.getId());
        response.setName(employee.getName());
        response.setSalary(employee.getSalary());

        // BeanUtils
        // BeanUtils.copyProperties(employee, response);

        return response;
    }

    public Employee toEntity(EmployeeRequest employeeRequest) {
        Employee employee = new Employee();

        // Manually
        employee.setAge(employeeRequest.getAge());
        employee.setCompanyId(employeeRequest.getCompanyId());
        employee.setGender(employeeRequest.getGender());
        employee.setName(employeeRequest.getName());
        employee.setSalary(employeeRequest.getSalary());

        // BeanUtils
        // BeanUtils.copyProperties(employeeRequest, employee);

        return employee;
    }
}

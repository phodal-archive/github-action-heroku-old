package com.thoughtworks.training.service;

import com.thoughtworks.training.exception.EmployeeNotFoundException;
import com.thoughtworks.training.model.entity.Employee;
import com.thoughtworks.training.repository.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public Page<Employee> getAll(Integer page, Integer pageSize) {
        return employeeRepository.findAll(PageRequest.of(page, pageSize));
    }

    public Employee get(Integer employeeId) {
        return employeeRepository.findById(employeeId).orElseThrow(() -> new EmployeeNotFoundException("Employee ID not found."));
    }

    public Employee create(Employee employeeRequest) {
        return employeeRepository.save(employeeRequest);
    }

    public void delete(Integer employeeId) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        employee.ifPresent(employeeRepository::delete);
    }

    public Employee update(Integer employeeId, Employee updatingEmployee) {
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        if (employee != null) {
            if (updatingEmployee.getName() != null) {
                employee.setName(updatingEmployee.getName());
            }
            if (updatingEmployee.getAge() != null) {
                employee.setAge(updatingEmployee.getAge());
            }
            if (updatingEmployee.getGender() != null) {
                employee.setGender(updatingEmployee.getGender());
            }
            return employeeRepository.save(employee);
        }
        throw new EmployeeNotFoundException("Employee Id Not Found.");
    }

    public List<Employee> getByGender(String gender) {
        return employeeRepository.findAllByGender(gender);
    }
}

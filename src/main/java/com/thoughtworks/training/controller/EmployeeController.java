package com.thoughtworks.training.controller;

import com.thoughtworks.training.mapper.EmployeeMapper;
import com.thoughtworks.training.model.dto.EmployeeRequest;
import com.thoughtworks.training.model.dto.EmployeeResponse;
import com.thoughtworks.training.model.entity.Employee;
import com.thoughtworks.training.service.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;

    public EmployeeController(EmployeeService employeeService, EmployeeMapper employeeMapper) {
        this.employeeService = employeeService;
        this.employeeMapper = employeeMapper;
    }

    @GetMapping
    public List<EmployeeResponse> getAll() {
        return employeeService.getAll().stream().map(employeeMapper::toResponse).collect(Collectors.toList());
    }

    @GetMapping(params = {"page", "pageSize"})
    public Page<EmployeeResponse> getPaginatedAll(
        @RequestParam(required = false) Integer page,
        @RequestParam(required = false) Integer pageSize
    ) {
        Page<Employee> employees = employeeService.getAll(page, pageSize);
        List<EmployeeResponse> responses = employees.getContent().stream().map(employeeMapper::toResponse).collect(Collectors.toList());
        return new PageImpl<>(responses, employees.getPageable(), employees.getTotalElements());
    }

    @GetMapping(params = "gender")
    public List<EmployeeResponse> getByGender(@RequestParam String gender) {
        return employeeService.getByGender(gender).stream().map(employeeMapper::toResponse).collect(Collectors.toList());
    }

    @GetMapping("/{employeeId}")
    public EmployeeResponse get(@PathVariable Integer employeeId) {
        Employee employee = employeeService.get(employeeId);
        return employeeMapper.toResponse(employee);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public EmployeeResponse create(@RequestBody EmployeeRequest employeeRequest) {
        Employee employee = employeeService.create(employeeMapper.toEntity(employeeRequest));
        return employeeMapper.toResponse(employee);
    }

    @DeleteMapping("/{employeeId}")
    public void delete(@PathVariable Integer employeeId) {
        employeeService.delete(employeeId);
    }

    @PutMapping("/{employeeId}")
    public EmployeeResponse update(@PathVariable Integer employeeId, @RequestBody EmployeeRequest employeeRequest) {
        Employee employee = employeeService.update(employeeId, employeeMapper.toEntity(employeeRequest));
        return employeeMapper.toResponse(employee);
    }
}

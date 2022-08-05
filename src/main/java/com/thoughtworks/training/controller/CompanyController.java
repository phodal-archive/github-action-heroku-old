package com.thoughtworks.training.controller;

import com.thoughtworks.training.mapper.CompanyMapper;
import com.thoughtworks.training.mapper.EmployeeMapper;
import com.thoughtworks.training.model.dto.CompanyRequest;
import com.thoughtworks.training.model.dto.CompanyResponse;
import com.thoughtworks.training.model.dto.EmployeeResponse;
import com.thoughtworks.training.model.entity.Company;
import com.thoughtworks.training.model.entity.Employee;
import com.thoughtworks.training.service.CompanyService;
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
@RequestMapping("/companies")
public class CompanyController {
    private final CompanyService companyService;
    private final CompanyMapper companyMapper;
    private final EmployeeMapper employeeMapper;

    public CompanyController(CompanyService companyService, CompanyMapper companyMapper, EmployeeMapper employeeMapper) {
        this.companyService = companyService;
        this.companyMapper = companyMapper;
        this.employeeMapper = employeeMapper;
    }

    @GetMapping
    public List<CompanyResponse> getAll() {
        List<Company> companies = companyService.getAll();
        return companies.stream().map(companyMapper::toResponse).collect(Collectors.toList());
    }

    @GetMapping(params = {"page", "pageSize"})
    public Page<CompanyResponse> getAll(
        @RequestParam(required = false) Integer page,
        @RequestParam(required = false) Integer pageSize
    ) {
        Page<Company> companies = companyService.getAll(page, pageSize);
        List<CompanyResponse> companyResponses = companies.get().map(companyMapper::toResponse).collect(Collectors.toList());
        return new PageImpl<>(companyResponses, companies.getPageable(), companies.getTotalElements());
    }

    @GetMapping("/{companyId}")
    public CompanyResponse get(@PathVariable Integer companyId) {
        Company company = companyService.get(companyId);
        return companyMapper.toResponse(company);
    }

    @GetMapping("/{companyId}/employees")
    public List<EmployeeResponse> getEmployees(@PathVariable Integer companyId) {
        List<Employee> employees = companyService.getEmployees(companyId);
        return employees.stream().map(employeeMapper::toResponse).collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public CompanyResponse create(@RequestBody CompanyRequest companyRequest) {
        Company company = companyService.create(companyMapper.toEntity(companyRequest));
        return companyMapper.toResponse(company);
    }

    @DeleteMapping("/{companyId}")
    public void deleteCompany(@PathVariable Integer companyId) {
        companyService.deleteCompany(companyId);
    }

    @PutMapping("/{companyId}")
    public CompanyResponse update(@PathVariable Integer companyId, @RequestBody CompanyRequest companyRequest) {
        Company company = companyService.update(companyId, companyMapper.toEntity(companyRequest));
        return companyMapper.toResponse(company);
    }
}

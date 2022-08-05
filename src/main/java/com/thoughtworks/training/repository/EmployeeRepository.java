package com.thoughtworks.training.repository;

import com.thoughtworks.training.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findAllByAgeBetween(Integer minAge, Integer maxAge);

    List<Employee> findAllByGender(String gender);

    List<Employee> findAllByCompanyId(Integer companyId);
}

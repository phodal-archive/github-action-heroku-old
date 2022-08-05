package com.thoughtworks.training.travisheroku.repository;

import com.thoughtworks.training.travisheroku.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

}

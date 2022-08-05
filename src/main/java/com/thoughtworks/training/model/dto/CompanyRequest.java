package com.thoughtworks.training.model.dto;

public class CompanyRequest {
    private String companyName;

    public CompanyRequest() {
    }

    public CompanyRequest(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}

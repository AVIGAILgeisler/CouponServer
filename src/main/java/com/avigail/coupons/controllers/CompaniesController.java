package com.avigail.coupons.controllers;

import com.avigail.coupons.exception.ApplicationException;
import com.avigail.coupons.dto.Company;
import com.avigail.coupons.logic.CompanyLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompaniesController {

    private CompanyLogic companyLogic;

    @Autowired
    public CompaniesController(CompanyLogic companyLogic) {
        this.companyLogic = companyLogic;
    }

    @PostMapping
    public void addCompany(@RequestBody Company company) throws ApplicationException {
         this.companyLogic.addCompany(company);
    }

    @PutMapping
    public void updateCompany(@RequestBody Company company) throws ApplicationException {
        this.companyLogic.updateCompany(company);
    }

    @DeleteMapping("/{id}")
    public void deleteCompany(@PathVariable ("id") long id) throws ApplicationException {
        this.companyLogic.deleteCompany(id);
    }
    //http://localhost:8080/companies
    @GetMapping
    public List<Company> getAllCompanies() throws ApplicationException {
        return this.companyLogic.getAllCompanies();
    }
    //http://localhost:8080/companies/1
    @GetMapping("/{id}")
    public Company getCompany(@PathVariable ("id") long id) throws ApplicationException {
        return this.companyLogic.getCompany(id);
    }
}

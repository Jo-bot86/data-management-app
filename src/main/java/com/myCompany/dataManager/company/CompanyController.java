package com.myCompany.dataManager.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/company")
@CrossOrigin("http://localhost:3000")
public class CompanyController {

    private CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService){
        this.companyService = companyService;
    }

    @GetMapping
    public List<Company> getCompanies(){
        return companyService.getCompanies();
    }

    @PostMapping("/new")
    public void addNewCompany(Company company){
        companyService.addNewCompany(company);
    }



}

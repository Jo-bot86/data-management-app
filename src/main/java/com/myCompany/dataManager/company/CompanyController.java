package com.myCompany.dataManager.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/companies")
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

    @PostMapping(consumes = "application/json")
    public void addNewCompany(@RequestBody Company company){
        companyService.addNewCompany(company);
    }

    @GetMapping("/{companyId}")
    @ResponseBody
    public Company getCompanyById(@PathVariable String companyId) {
       return companyService.getCompanyById(Long.valueOf(companyId));
    }

    @PutMapping(value = "/{companyId}", consumes = "application/json")
    public void updateCompany(@PathVariable String companyId, @RequestBody Company company){
        companyService.updateCompany(
                Long.valueOf(companyId),
                company.getFirstName(),
                company.getLastName(),
                company.getCompanyName(),
                company.getPhone(),
                company.getFax(),
                company.getEmailAddress());
    }

    @DeleteMapping("/{companyId}")
    @ResponseBody
    public void deleteCompany(@PathVariable String companyId){
        companyService.deleteCompany(Long.valueOf(companyId));
    }
}

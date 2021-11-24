package com.myCompany.dataManager.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyService(CompanyRepository companyRepository){
        this.companyRepository = companyRepository;
    }

    public List<Company> getCompanies(){
        return companyRepository.findAll();
    }

    public void addNewCompany(Company company){
        Optional<Company> companyOptional = companyRepository.findCompanyByEmailAddress(company.getEmailAddress());
        if(companyOptional.isPresent()){
            throw new IllegalStateException(
                    "company with the email address " + company.getEmailAddress() + " already exists"
            );
        }
        companyRepository.save(company);
    }

    public void deleteCompany(Long companyId){
        boolean exists = companyRepository.existsById(companyId);
        if(!exists){
            throw new IllegalStateException(
                    "company with id " + companyId + " does not exists"
            );
        }
        companyRepository.getById(companyId).setDeleted(true);
    }

    @Transactional
    public void updateCompany(Long companyId,
                              String firstName,
                              String lastName,
                              String companyName,
                              String phone,
                              String fax,
                              String emailAddress){
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new IllegalStateException(
                        "company with id " + companyId + " does not exists"
                ));
        if(firstName != null && firstName.length()>0){
            company.setFirstName(firstName);
        }
        if(lastName != null && lastName.length() >0){
            company.setLastName(lastName);
        }
        if(companyName != null && companyName.length() >0){
            company.setCompanyName(companyName);
        }
        if(phone != null && phone.length()>0){
            company.setPhone(phone);
        }
        if(fax != null && fax.length()>0){
            company.setFax(fax);
        }
        if(emailAddress !=null && emailAddress.length()>0){
            Optional<Company> companyOptional = companyRepository.findCompanyByEmailAddress(emailAddress);
            if(companyOptional.isPresent()){
                throw new IllegalStateException("email already exists");
            }
            company.setEmailAddress(emailAddress);
        }

    }
}

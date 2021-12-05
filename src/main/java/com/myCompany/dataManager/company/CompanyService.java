package com.myCompany.dataManager.company;

import com.myCompany.dataManager.address.Address;
import com.myCompany.dataManager.address.AddressRepository;
import com.myCompany.dataManager.address.AddressService;
import com.myCompany.dataManager.company.exception.CompanyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;
import java.util.stream.IntStream;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final AddressService addressService;

    private Random random;

    @Autowired
    public CompanyService(CompanyRepository companyRepository, AddressService addressService){
        this.companyRepository = companyRepository;
        this.addressService = addressService;
    }

    public List<Company> getCompanies(){
        return companyRepository.findAll();
    }

    public Company getCompanyById(Long companyId) {
        return companyRepository.findById(companyId).orElseThrow(() ->
                new CompanyNotFoundException(companyId));
    }

    public Company addNewCompany(Company company){
        Optional<Company> companyOptional = companyRepository.findCompanyByEmailAddress(company.getEmailAddress());
        if(companyOptional.isPresent() && !companyOptional.get().getDeleted()){
            throw new IllegalStateException(
                    "company with the email address " + company.getEmailAddress() + " already exists"
            );
        }
        random = new Random();
        int companyNumber = random.nextInt(89_999_999) + 10_000_000;
        companyOptional = companyRepository.findCompanyByCompanyNumber(Integer.toString(companyNumber));
        while(companyOptional.isPresent()){
            companyNumber = random.nextInt(89_999_999) + 10_000_000;
            companyOptional = companyRepository.findCompanyByCompanyNumber(Integer.toString(companyNumber));
        }
        company.setDeleted(false);
        company.setCompanyNr(Integer.toString(companyNumber));
        return companyRepository.save(company);
    }

    public Company deleteCompany(Long companyId){
        Company company = getCompanyById(companyId);
        companyRepository.delete(company);
        return company;
    }

    @Transactional
    public Company updateCompany(Long companyId,
                              String firstName,
                              String lastName,
                              String companyName,
                              String phone,
                              String fax,
                              String emailAddress){
        Company company = getCompanyById(companyId);
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
        if(emailAddress !=null && emailAddress.length()>0) {
            company.setEmailAddress(emailAddress);
        }
        return company;
    }

    @Transactional
    public Company addAddressToCompany(Long companyId, Long addressId){
        Company company = getCompanyById(companyId);
        Address address = addressService.getAddressById(addressId);
        company.getAddress().add(address);
        return company;
    }

    @Transactional
    public Company removeAddressFromCompany(Long companyId, Long addressId){
        Company company = getCompanyById(companyId);
        Address address = addressService.getAddressById(addressId);
        company.getAddress().remove(address);
        return company;
    }
}

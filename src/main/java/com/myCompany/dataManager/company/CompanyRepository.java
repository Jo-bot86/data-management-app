package com.myCompany.dataManager.company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {


    @Query("SELECT c FROM Company c WHERE c.emailAddress = ?1")
    Optional<Company> findCompanyByEmailAddress(String email);

    @Query("SELECT c FROM Company c WHERE c.companyNr = ?1")
    Optional<Company> findCompanyByCompanyNumber(String companyNr);

}

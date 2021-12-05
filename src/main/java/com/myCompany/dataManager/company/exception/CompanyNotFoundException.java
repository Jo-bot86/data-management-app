package com.myCompany.dataManager.company.exception;

import java.text.MessageFormat;

public class CompanyNotFoundException extends RuntimeException{
    public CompanyNotFoundException(Long companyId) {
        super(MessageFormat.format("Could not find company with id: {0}", companyId));
    }
}

package com.myCompany.dataManager.address.exception;

import java.text.MessageFormat;

public class AddressNotFoundException extends RuntimeException{
    public AddressNotFoundException(Long addressId) {
        super(MessageFormat.format("Could not find address with id: {0}", addressId));
    }
}

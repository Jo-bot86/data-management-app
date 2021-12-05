package com.myCompany.dataManager.address;

import com.myCompany.dataManager.address.exception.AddressNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AddressService {

    private AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository){
        this.addressRepository = addressRepository;
    }

    public List<Address> getAddresses(){
        return addressRepository.findAll();
    }

    public Address getAddressById(Long addressId) {
        return addressRepository.findById(addressId).orElseThrow(() ->
                new AddressNotFoundException(addressId));
    }

    public Address addNewAddress(Address address){
        return addressRepository.save(address);
    }

    public Address deleteAddress(Long addressId){
        Address address = getAddressById(addressId);
        addressRepository.deleteById(addressId);
        return address;
    }

    @Transactional
    public Address updateAddress(Long addressId, Address address){
        Address addressToUpdate = getAddressById(addressId);
        addressToUpdate.setAddressTyp(address.getAddressTyp());
        addressToUpdate.setCity(address.getCity());
        addressToUpdate.setCountry(address.getCountry());
        addressToUpdate.setStreet(address.getStreet());
        return addressToUpdate;
    }
}

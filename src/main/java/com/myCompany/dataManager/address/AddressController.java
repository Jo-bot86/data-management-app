package com.myCompany.dataManager.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/addresses")
public class AddressController {

    private AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService){
        this.addressService = addressService;
    }

    @GetMapping
    public List<Address> getAddresses(){
        return addressService.getAddresses();
    }

    @PostMapping(consumes = "application/json")
    public void addNewAddress(@RequestBody Address address){
        addressService.addNewAddress(address);
    }

    @GetMapping(value = "/{addressId}")
    public Address getAddress(@PathVariable String addressId){
        return addressService.getAddressById(Long.valueOf(addressId));
    }

    @DeleteMapping(value = "/{addressId}")
    @ResponseBody
    public void deleteAddress(@PathVariable String addressId){
        addressService.deleteAddress(Long.valueOf(addressId));
    }

    @PutMapping(value = "/{addressId}")
    @ResponseBody
    public void updateAddress(@PathVariable String addressId, @RequestBody Address address){
        addressService.updateAddress(Long.valueOf(addressId), address);
    }
}

package com.myCompany.dataManager.address;

import com.myCompany.dataManager.company.Company;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name="address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long addressId;

    /*@ManyToOne
    @JoinColumn(name = "companyId")
    private Long companyId;*/

    @Column(name="street", columnDefinition = "NVARCHAR(255)")
    @NotNull
    private String street;

    @Column(name="postCode", columnDefinition = "NVARCHAR(10)")
    @NotNull
    private String postCode;

    @Column(name="city", columnDefinition = "NVARCHAR(100)")
    @NotNull
    private String city;

    @Column(name="country", columnDefinition = "NVARCHAR(150)")
    @NotNull
    private String country;

    @Column(name = "addresstyp", columnDefinition = "NVARCHAR(4)")
    @NotNull
    private String addressTyp;


    public Address() {

    }

    public Address(String street, String postCode, String city, String country, String addressTyp) {
        /*this.companyId = companyId;*/
        this.street = street;
        this.postCode = postCode;
        this.city = city;
        this.country = country;
        this.addressTyp = addressTyp;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    /*public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }*/

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddressTyp() {
        return addressTyp;
    }

    public void setAddressTyp(String addressTyp) {
        this.addressTyp = addressTyp;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                /*", companyId=" + companyId +*/
                ", street='" + street + '\'' +
                ", postCode='" + postCode + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", addressTyp='" + addressTyp + '\'' +
                '}';
    }
}

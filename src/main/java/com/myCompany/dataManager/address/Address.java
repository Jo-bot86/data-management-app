package com.myCompany.dataManager.address;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long addressId;

    private Long companyId;
}

package com.myCompany.dataManager.company;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    @NotNull
    private Long companyId;

    @Column(name="firstname", columnDefinition = "NVARCHAR(60)")
    @NotNull
    private String firstName;

    @Column(name="lastname", columnDefinition = "NVARCHAR(255)")
    @NotNull
    private String lastName;

    @Column(name="companyname", columnDefinition = "NVARCHAR(255)")
    @NotNull
    private String companyName;

    @Column(name="companynr",
            columnDefinition = "NVARCHAR(80)",
            unique = true)
    @SequenceGenerator(name = "companynr")
    @NotNull
    private String companyNr;

    @Column(name="phone", columnDefinition = "NVARCHAR(20)")
    @NotNull
    private String phone;

    @Column(name="fax", columnDefinition = "NVARCHAR(20)")
    @NotNull
    private String fax;

    @Column(name="emailaddress", columnDefinition = "NVARCHAR(255)")
    @NotNull
    private String emailAddress;

    @Column(name="isdeleted")
    private Boolean isDeleted;

    public Company() {
    }

    public Company(String firstName,
                   String lastName,
                   String companyName,
                   String companyNr,
                   String phone,
                   String fax,
                   String emailAddress,
                   Boolean isDeleted) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.companyName = companyName;
        this.companyNr = companyNr;
        this.phone = phone;
        this.fax = fax;
        this.emailAddress = emailAddress;
        this.isDeleted = isDeleted;
    }

    public void setId(Long id) {
        this.companyId = id;
    }

    public Long getId() {
        return companyId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyNr() {
        return companyNr;
    }

    public void setCompanyNr(String companyNr) {
        this.companyNr = companyNr;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + companyId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", companyNr=" + companyNr +
                ", phone='" + phone + '\'' +
                ", fax='" + fax + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", isDeleted=" + isDeleted +
                '}';
    }
}

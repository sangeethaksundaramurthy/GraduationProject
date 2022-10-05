package com.example.GraduationProject.Business.Entity;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "Taker")
public class Taker
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")

    private int id;
    @Size(min=3, max=30)
    @Column(name = "Name")
    private String name;
    @Size(min=5, max=15)
    @Column(name = "LicenseId")
    private String licenseId;
    @Size(min=10, max=50)
    @Column(name = "Address")
    private String address;

    @Range(min= 10000, max = 999999)
    @Column(name = "PostalCode")
    private int postalCode;
    @Size(min=10, max=10)
    @Column(name = "Phone")
    private String phone;
    @Size(min =0, max=50)
    @Column(name = "AllergyInformation")
    private String allergyInformation;
    @Email
    @NotBlank
    @Column(name = "EmailId")
    private String emailId;

    public Taker()
    {
    }

    public Taker(String name, String licenseId, String address, int postalCode, String phone, String allergyInformation, String emailId)
    {
        this.name = name;
        this.licenseId = licenseId;
        this.address = address;
        this.postalCode = postalCode;
        this.phone = phone;
        this.allergyInformation = allergyInformation;
        this.emailId = emailId;
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getLicenseId()
    {
        return licenseId;
    }

    public void setLicenseId(String licenseId)
    {
        this.licenseId = licenseId;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public int getPostalCode()
    {
        return postalCode;
    }

    public void setPostalCode(int postalCode)
    {
        this.postalCode = postalCode;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getAllergyInformation()
    {
        return allergyInformation;
    }

    public void setAllergyInformation(String allergyInformation)
    {
        this.allergyInformation = allergyInformation;
    }

    public String getEmailId()
    {
        return emailId;
    }

    public void setEmailId(String emailId)
    {
        this.emailId = emailId;
    }

    @Override public String toString()
    {
        return "Taker{" + "name='" + name + '\'' + ", licenseId='" + licenseId + '\'' + ", address='" + address + '\'' + ", postalCode=" + postalCode + ", phone=" + phone + ", allergyInformation='" + allergyInformation + '\'' + ", emailId='" + emailId + '\'' + '}';
    }
}

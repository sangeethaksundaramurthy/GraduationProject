package com.example.GraduationProject.Business.Entity;

import javax.persistence.*;

@Entity
@Table(name = "Taker")
public class Taker
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private int id;
    @Column(name = "Name")
    private String name;
    @Column(name = "LicenseId")
    private String licenseId;
    @Column(name = "Address")
    private String address;
    @Column(name = "PostalCode")
    private int postalCode;
    @Column(name = "Phone")
    private int phone;
    @Column(name = "AllergyInformation")
    private String allergyInformation;
    @Column(name = "EmailId")
    private String emailId;

    public Taker()
    {
    }

    public Taker(String name, String licenseId, String address, int postalCode, int phone, String allergyInformation, String emailId)
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

    public int getPhone()
    {
        return phone;
    }

    public void setPhone(int phone)
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

package com.example.GraduationProject.Business.Entity;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

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


    @Size(min=10, max=50)
    @Column(name = "Address")
    private String address;

    @NotNull
    @Range(min= 10000, max = 999999)
    @Column(name = "PostalCode")
    private Integer postalCode;

    @Size(min=10, max=13)
    @Column(name = "Phone")
    private String phone;

    @Size(min =0, max=50)
    @Column(name = "AllergyInformation")
    private String allergyInformation;

    @Email
    @NotBlank
    @Column(name = "EmailId",  unique = true)
    private String emailId;

    @NotBlank
    @Column(name= "Password")
    private String password;

    @OneToMany(mappedBy = "taker", cascade = CascadeType.ALL)
    private List<Food> foods;
    public Taker()
    {
    }

    public Taker(String name, String address, Integer postalCode, String phone, String allergyInformation, String emailId, String password)
    {
        this.name = name;
        this.address = address;
        this.postalCode = postalCode;
        this.phone = phone;
        this.allergyInformation = allergyInformation;
        this.emailId = emailId;
        this.password = password;
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

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public Integer getPostalCode()
    {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode)
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

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public java.util.List<Food> getFoodItems()
    {
        return foods;
    }

    public void setFoodItems(java.util.List<Food> foods)
    {
        this.foods = foods;
    }

    @Override
    public String toString() {
        return "Taker{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", postalCode=" + postalCode +
                ", phone='" + phone + '\'' +
                ", allergyInformation='" + allergyInformation + '\'' +
                ", emailId='" + emailId + '\'' +
                ", password='" + password + '\'' +
                ", foods=" + foods +
                '}';
    }
}

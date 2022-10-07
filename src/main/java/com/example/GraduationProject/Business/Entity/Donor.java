package com.example.GraduationProject.Business.Entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Donor")
public class Donor
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private int id;

    @Size(min = 3, max = 30)
    @Column(name = "Name")
    private String name;

    @Size(min=10, max=50)
    @Column(name = "Address")
    private String address;

    @Size(min = 10, max = 10)
    @Column(name = "Phone")
    private String phone;

    @Email
    @NotBlank
    @Column(name = "EmailId",  unique = true)
    private String emailId;

    @NotBlank
    @Column(name = "Password")
    private String password;

    @OneToMany(mappedBy = "donor", cascade = CascadeType.ALL)
    private List<FoodItem> foodItems;

    public Donor()
    {
    }

    public Donor(String name, String address, String phone, String emailId, String password)
    {
        this.name = name;
        this.address = address;
        this.phone = phone;
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

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
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

    public java.util.List<FoodItem> getFoodItems()
    {
        return foodItems;
    }

    public void setFoodItems(java.util.List<FoodItem> foodItems)
    {
        this.foodItems = foodItems;
    }

    @Override public String toString()
    {
        return "Donor{" + "name='" + name + '\'' + ", address='" + address + '\'' + ", phone='" + phone + '\'' + ", emailId='" + emailId + '\'' + ", password='" + password + '\'' + ", foodItems=" + foodItems + '}';
    }
}

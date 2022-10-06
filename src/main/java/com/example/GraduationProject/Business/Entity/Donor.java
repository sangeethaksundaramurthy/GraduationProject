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
    @Size(min = 10, max = 10)
    @Column(name = "Phone")
    private String phone;
    @PastOrPresent
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "DateOfBirth")
    private Date dateOfBirth;
    @Email
    @NotBlank
    @Column(name = "EmailId")
    private String emailId;

    @NotBlank
    @Column(name= "Password")
    private String password;

    @OneToMany(mappedBy = "donor", cascade = CascadeType.ALL)
    private List<FoodItem> foodItems;
    public Donor()
    {
    }

    public Donor(String name, String phone, Date dateOfBirth, String emailId, String password)
    {
        this.name = name;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
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

    public String getPhone() { return phone; }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public Date getDateOfBirth()
    {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
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

    public List<FoodItem> getFoodItems()
    {
        return foodItems;
    }

    public void setFoodItems(List<FoodItem> foodItems)
    {
        this.foodItems = foodItems;
    }
}

package com.example.GraduationProject.Business.Entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "FoodItem")
public class FoodItem
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private int id;

    @Size(min = 3, max = 30)
    @Column(name = "Name")
    private String name;

    @NotNull
    @Column(name = "Category")
    private String category;

    @Size(min = 3, max = 100)
    @Column(name = "AllergyInformation")
    private String allergyInformation;

    @NotNull
    @FutureOrPresent
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "ExpiryDate")
    private Date expiryDate;

    @Size(min = 1, max = 100)
    @Column(name = "Quantity")
    private String quantity;

    @NotNull
    @Column(name = "Status")
    private String status;

    @Column(name = "Image")
    private String image;

    @ManyToOne
    private Donor donor;

    @ManyToOne
    private Taker taker;

    @ManyToOne
    private Volunteer volunteer;

    public FoodItem()
    {
    }

    public FoodItem(String name, String category, String allergyInformation, Date expiryDate, String quantity, String status, String image, Donor donor)
    {
        this.name = name;
        this.category = category;
        this.allergyInformation = allergyInformation;
        this.expiryDate = expiryDate;
        this.quantity = quantity;
        this.status = status;
        this.image = image;
        this.donor = donor;
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

    public String getCategory()
    {
        return category;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    public String getAllergyInformation()
    {
        return allergyInformation;
    }

    public void setAllergyInformation(String allergyInformation)
    {
        this.allergyInformation = allergyInformation;
    }

    public java.util.Date getExpiryDate()
    {
        return expiryDate;
    }

    public void setExpiryDate(java.util.Date expiryDate)
    {
        this.expiryDate = expiryDate;
    }

    public String getQuantity()
    {
        return quantity;
    }

    public void setQuantity(String quantity)
    {
        this.quantity = quantity;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getImage()
    {
        return image;
    }

    public void setImage(String image)
    {
        this.image = image;
    }

    public com.example.GraduationProject.Business.Entity.Donor getDonor()
    {
        return donor;
    }

    public void setDonor(com.example.GraduationProject.Business.Entity.Donor donor)
    {
        this.donor = donor;
    }

    public com.example.GraduationProject.Business.Entity.Taker getTaker()
    {
        return taker;
    }

    public void setTaker(com.example.GraduationProject.Business.Entity.Taker taker)
    {
        this.taker = taker;
    }

    public Volunteer getVolunteers()
    {
        return volunteer;
    }

    public void setVolunteers(Volunteer volunteer)
    {
        this.volunteer = volunteer;
    }

    @Override public String toString()
    {
        return "FoodItem{" + "name='" + name + '\'' + ", category='" + category + '\'' + ", allergyInformation='" + allergyInformation + '\'' + ", expiryDate=" + expiryDate + ", quantity='" + quantity + '\'' + ", status='" + status + '\'' + ", image='" + image + '\'' + ", donor=" + donor + ", taker=" + taker + ", volunteer=" + volunteer + '}';
    }
}

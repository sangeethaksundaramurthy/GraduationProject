package com.example.GraduationProject.Business.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "FoodItem")
public class FoodItem
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Category")
    private String category;
    @Column(name = "AllergyInformation")
    private String allergyInformation;
    @Column(name = "ExpiryDate")
    private Date expiryDate;
    @Column(name = "Quantity")
    private String Quantity;
    @Column(name = "Status")
    private String status;
    @Column(name = "Image")
    private String image;

    public FoodItem()
    {
    }

    public FoodItem(String name, String category, String allergyInformation, Date expiryDate, String quantity, String status, String image)
    {
        this.name = name;
        this.category = category;
        this.allergyInformation = allergyInformation;
        this.expiryDate = expiryDate;
        Quantity = quantity;
        this.status = status;
        this.image = image;
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

    public Date getExpiryDate()
    {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate)
    {
        this.expiryDate = expiryDate;
    }

    public String getQuantity()
    {
        return Quantity;
    }

    public void setQuantity(String quantity)
    {
        Quantity = quantity;
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
}

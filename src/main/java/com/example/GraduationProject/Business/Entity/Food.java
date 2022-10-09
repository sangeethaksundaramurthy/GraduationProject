package com.example.GraduationProject.Business.Entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "Food")
public class Food
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

    @NotNull
    @Column(name = "Category")
    private String category;

    @NotNull
    @FutureOrPresent
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "ExpiryDate")
    private Date expiryDate;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @Column(name = "Time")
    private Time time;

    @Size(min = 1, max = 100)
    @Column(name = "Quantity")
    private String quantity;

    @NotNull
    @Column(name = "Status")
    private String status;

    @Size(min = 3, max = 100)
    @Column(name = "AllergyInformation")
    private String allergyInformation;

    @Column(name = "Image")
    private String image;

    @ManyToOne
    private Donor donor;

    @ManyToOne
    private Taker taker;

    @ManyToOne
    private Volunteer volunteer;

    public Food()
    {
    }

    public Food(String name, String address, String category, Date expiryDate, Time time, String quantity, String status, String allergyInformation, String image)
    {
        this.name = name;
        this.address = address;
        this.category = category;
        this.expiryDate = expiryDate;
        this.time = time;
        this.quantity = quantity;
        this.status = status;
        this.allergyInformation = allergyInformation;
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

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getCategory()
    {
        return category;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    public Date getExpiryDate()
    {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate)
    {
        this.expiryDate = expiryDate;
    }

    public Time getTime()
    {
        return time;
    }

    public void setTime(Time time)
    {
        this.time = time;
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

    public String getAllergyInformation()
    {
        return allergyInformation;
    }

    public void setAllergyInformation(String allergyInformation)
    {
        this.allergyInformation = allergyInformation;
    }

    public String getImage()
    {
        return image;
    }

    public void setImage(String image)
    {
        this.image = image;
    }

    public Donor getDonor()
    {
        return donor;
    }

    public void setDonor(Donor donor)
    {
        this.donor = donor;
    }

    public Taker getTaker()
    {
        return taker;
    }

    public void setTaker(Taker taker)
    {
        this.taker = taker;
    }

    public Volunteer getVolunteer()
    {
        return volunteer;
    }

    public void setVolunteer(Volunteer volunteer)
    {
        this.volunteer = volunteer;
    }

    @Override public String toString()
    {
        return "Food{" + "name='" + name + '\'' + ", address='" + address + '\'' + ", category='" + category + '\'' + ", expiryDate=" + expiryDate + ", time=" + time + ", quantity='" + quantity + '\'' + ", status='" + status + '\'' + ", allergyInformation='" + allergyInformation + '\'' + ", image='" + image + '\'' + ", donor=" + donor + ", taker=" + taker + ", volunteer=" + volunteer + '}';
    }
}

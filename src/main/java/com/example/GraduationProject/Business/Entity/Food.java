package com.example.GraduationProject.Business.Entity;

import com.example.GraduationProject.Business.FoodStatus;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "Food")
public class Food
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Size(min = 3, max = 30)
    private String name;
    @Size(min=10, max=50)
    private String address;
    @NotNull
    private String category;
    @NotNull
    @FutureOrPresent
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate bestBefore;
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private String pickUpTime;
    @Size(min = 1, max = 100)
    @Positive
    private String quantity;
    private FoodStatus status;

    @Size(min = 3, max = 100)
    private String allergyInformation;


    private String image;

    @ManyToOne
    private Donor donor;

    @ManyToOne
    private Taker taker;

    @ManyToOne
    private Volunteer volunteer;

    public Food()
    {
        this.status= FoodStatus.AVAILABLE;
    }

/*    public Food(String name, String address, String category, LocalDate bestBefore, LocalTime pickUpTime, String quantity, String status, String allergyInformation, String image)
    {
        this.name = name;
        this.address = address;
        this.category = category;
        this.bestBefore = bestBefore;
        this.pickUpTime = pickUpTime;
        this.quantity = quantity;
        this.status = ;
        this.allergyInformation = allergyInformation;
        this.image = image;
    }*/

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

    public LocalDate getBestBefore()
    {
        return bestBefore;
    }

    public void setBestBefore(LocalDate bestBefore)
    {
        this.bestBefore = bestBefore;
    }

    public String getPickUpTime()
    {
        return pickUpTime;
    }

    public void setPickUpTime(String pickUpTime)
    {
        this.pickUpTime = pickUpTime;
    }

    public String getQuantity()
    {
        return quantity;
    }

    public void setQuantity(String quantity)
    {
        this.quantity = quantity;
    }

    public FoodStatus getStatus()
    {
        return status;
    }

    public void setStatus(FoodStatus status)
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
        return "Food{" + "name='" + name + '\'' + ", address='" + address + '\'' + ", category='" + category + '\'' + ", bestBefore=" + bestBefore + ", pickUpTime=" + pickUpTime + ", quantity='" + quantity + '\'' + ", status='" + status + '\'' + ", allergyInformation='" + allergyInformation + '\'' + ", image='" + image + '\'' + ", donor=" + donor + ", taker=" + taker + ", volunteer=" + volunteer + '}';
    }
}

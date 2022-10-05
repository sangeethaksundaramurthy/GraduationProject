package com.example.GraduationProject.Business.Entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.util.Date;

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

    public Donor()
    {
    }

    public Donor(String name, String phone, Date dateOfBirth, String emailId)
    {
        this.name = name;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
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
}

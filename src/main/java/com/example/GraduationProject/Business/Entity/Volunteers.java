package com.example.GraduationProject.Business.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Volunteers")
public class Volunteers
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private int id;

    @Column(name = "Name")
    private String name;
    @Column(name = "Phone")
    private int phone;
    @Column(name = "DateOfBirth")
    private Date dateOfBirth;
    @Column(name = "EmailId")
    private String emailId;

    public Volunteers()
    {
    }

    public Volunteers(String name, int phone, Date dateOfBirth, String emailId)
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

    public int getPhone()
    {
        return phone;
    }

    public void setPhone(int phone)
    {
        this.phone = phone;
    }

    public Date getDOB()
    {
        return dateOfBirth;
    }

    public void setDOB(Date dateOfBirth)
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

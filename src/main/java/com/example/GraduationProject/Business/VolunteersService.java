package com.example.GraduationProject.Business;

import com.example.GraduationProject.Business.Entity.Volunteer;
import com.example.GraduationProject.Repository.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;

@Service
@SessionScope
public class VolunteersService
{
    @Autowired
    VolunteerRepository repository;

    Volunteer volunteer;
    public void save(Volunteer volunteer)
    {
        repository.save(volunteer);
    }

    public Volunteer authenticate(String emailId, String password)
    {
        List<Volunteer> volunteers = repository.findByEmailIdAndPassword(emailId, password);
        if(volunteers.isEmpty())
            return null;
        else
        {
            volunteer = volunteers.get(0);
            return volunteer;
        }
    }

}

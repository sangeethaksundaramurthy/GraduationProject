package com.example.GraduationProject.Business;

import com.example.GraduationProject.Business.Entity.Donor;
import com.example.GraduationProject.Repository.DonorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;

@Service
@SessionScope
public class DonorService
{
    @Autowired
    DonorRepository repository;

    Donor donor;
    public void save(Donor donor)
    {
        repository.save(donor);
    }

    public Donor authenticate(String emailId, String password)
    {
        List<Donor> donors = repository.findByEmailIdAndPassword(emailId, password);
        if(donors.isEmpty())
            return null;
        else
        {
            donor = donors.get(0);
            return donor;
        }
    }
}

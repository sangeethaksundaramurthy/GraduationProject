package com.example.GraduationProject.Business;

import com.example.GraduationProject.Business.Entity.Donor;
import com.example.GraduationProject.Business.Entity.Food;
import com.example.GraduationProject.Repository.DonorRepository;
import com.example.GraduationProject.Repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;

@Service
@SessionScope
public class DonorService
{
    @Autowired
    DonorRepository donorRepository;

    @Autowired
    FoodRepository foodRepository;
    Donor donor;
    public String save(Donor donor)
    {
        List<Donor> donors = donorRepository.findByEmailId(donor.getEmailId());
        if(donors.isEmpty())
        {
            donorRepository.save(donor);
            return "Success";
        }
        else
            return "Failed";
    }

    public Donor authenticate(String emailId, String password)
    {
        List<Donor> donors = donorRepository.findByEmailIdAndPassword(emailId, password);
        if(donors.isEmpty())
            return null;
        else
        {
            donor = donors.get(0);
            return donor;
        }
    }

    public void save(Food food)
    {
        foodRepository.save(food);
    }
}

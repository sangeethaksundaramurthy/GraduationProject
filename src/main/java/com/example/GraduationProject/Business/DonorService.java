package com.example.GraduationProject.Business;

import com.example.GraduationProject.Business.Entity.Donor;
import com.example.GraduationProject.Business.Entity.Food;
import com.example.GraduationProject.Repository.DonorRepository;
import com.example.GraduationProject.Repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collections;
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
    Food food;

    public Donor getDonor()
    {
        return donor;
    }

    public Food getFood()
    {
        return food;
    }

    public String save(Donor donor)
    {
        List<Donor> donors = donorRepository.findByEmailId(donor.getEmailId());
        if(donors.isEmpty())
        {
            donorRepository.save(donor);
            this.donor = donor;
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
            this.donor = donors.get(0);
            return donor;
        }
    }

    public void save(Food food)
    {
        food.setDonor(donor);
        foodRepository.save(food);
        this.food =food;
    }

    public void setPickUpRequired(String pickUp)
    {
        food.setPickUpRequired(Boolean.parseBoolean(pickUp));
        save(food);
    }

    public List<Food> donationHistory()
    {
        return foodRepository.findAllByDonorId(donor.getId());
    }

    public List<Food> availFood() {
        return foodRepository.findAllByStatus(FoodStatus.AVAILABLE);
    }
}

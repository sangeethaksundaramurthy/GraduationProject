package com.example.GraduationProject.Business;

import com.example.GraduationProject.Business.Entity.Donor;
import com.example.GraduationProject.Business.Entity.FoodItem;
import com.example.GraduationProject.Business.Entity.Taker;
import com.example.GraduationProject.Business.Entity.Volunteers;
import com.example.GraduationProject.Repository.DonorRepository;
import com.example.GraduationProject.Repository.FoodItemRepository;
import com.example.GraduationProject.Repository.TakerRepository;
import com.example.GraduationProject.Repository.VolunteersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BeaHandService
{
    @Autowired
    TakerRepository takerRepository;

    @Autowired
    DonorRepository donorRepository;

    @Autowired
    VolunteersRepository volunteersRepository;

    @Autowired
    FoodItemRepository foodItemRepository;

    public void addTaker(Taker taker)
    {
        takerRepository.save(taker);
    }

    public void addFoodItem(FoodItem foodItem)
    {
        foodItemRepository.save(foodItem);
    }

    public void addVolunteers(Volunteers volunteers)
    {
        volunteersRepository.save(volunteers);
    }

    public void addDonor(Donor donor)
    {
        donorRepository.save(donor);
    }
}

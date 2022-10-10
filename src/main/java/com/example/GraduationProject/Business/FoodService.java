package com.example.GraduationProject.Business;

import com.example.GraduationProject.Business.Entity.Donor;
import com.example.GraduationProject.Business.Entity.Food;
import com.example.GraduationProject.Repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService
{
    @Autowired
    FoodRepository repository;

    public void save(Food food)
    {
        repository.save(food);
    }
}

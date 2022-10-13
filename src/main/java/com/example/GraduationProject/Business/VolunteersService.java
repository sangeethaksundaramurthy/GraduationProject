package com.example.GraduationProject.Business;

import com.example.GraduationProject.Business.Entity.Donor;
import com.example.GraduationProject.Business.Entity.Food;
import com.example.GraduationProject.Business.Entity.Volunteer;
import com.example.GraduationProject.Repository.FoodRepository;
import com.example.GraduationProject.Repository.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collections;
import java.util.List;

@Service
@SessionScope
public class VolunteersService
{
    @Autowired
    VolunteerRepository volunteerRepository;
    @Autowired
    FoodRepository foodRepository;
    Volunteer volunteer;
    Food food;

    public Volunteer getVolunteer()
    {
        return volunteer;
    }

    public Food getFood()
    {
        return food;
    }

    public String save(Volunteer volunteer)
    {
        List<Volunteer> volunteers = volunteerRepository.findByEmailId(volunteer.getEmailId());
        if(volunteers.isEmpty())
        {
            volunteerRepository.save(volunteer);
            this.volunteer = volunteer;
            return "Success";
        }
        else
            return "Failed";
    }

    public Volunteer authenticate(String emailId, String password)
    {
        List<Volunteer> volunteers = volunteerRepository.findByEmailIdAndPassword(emailId, password);
        if(volunteers.isEmpty())
            return null;
        else
        {
            this.volunteer = volunteers.get(0);
            return volunteer;
        }
    }
    public List<Food> acceptedFoodList()
    {
        return foodRepository.foodToBePickedUp();
    }

    public void acceptPickup(Integer id)
    {
        List<Food> foods = foodRepository.findAllById(Collections.singleton(id));
        foods.get(0).setStatus(FoodStatus.PICK_UP);
        foods.get(0).setVolunteer(volunteer);
        foodRepository.save(foods.get(0));
    }

    public List<Food> volunteerHistory()
    {
        System.out.println(volunteer.getId());
        return foodRepository.findAllByVolunteerId(volunteer.getId());
    }

    public void delivered(Integer id)
    {
        List<Food> foods = foodRepository.findAllById(Collections.singleton(id));
        foods.get(0).setStatus(FoodStatus.DELIVERED);
        foodRepository.save(foods.get(0));
    }
}

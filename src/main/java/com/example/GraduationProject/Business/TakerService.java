package com.example.GraduationProject.Business;

import com.example.GraduationProject.Business.Entity.Donor;
import com.example.GraduationProject.Business.Entity.Food;
import com.example.GraduationProject.Business.Entity.Taker;
import com.example.GraduationProject.Repository.FoodRepository;
import com.example.GraduationProject.Repository.TakerRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collections;
import java.util.List;

@Service
@SessionScope
public class TakerService
{
    @Autowired
    TakerRepository takerRepository;

    @Autowired
    FoodRepository foodRepository;

    Taker taker;

    public Taker getTaker()
    {
        return taker;
    }

    Food food;

    public Food getFood()
    {
        return food;
    }

    public String save(Taker taker)
    {
        List<Taker> takers = takerRepository.findByEmailId(taker.getEmailId());
        if(takers.isEmpty())
        {
            takerRepository.save(taker);
            this.taker = taker;
            return "Success";
        }
        else
            return "Failed";
    }

    public Taker authenticate(String emailId, String password)
    {
        List<Taker> takers = takerRepository.findByEmailIdAndPassword(emailId, password);
        if(takers.isEmpty())
            return null;
        else
        {
            this.taker = takers.get(0);
            return taker;
        }
    }

    public List<Food> viewDonations()
    {
        return foodRepository.findAllByStatus(FoodStatus.AVAILABLE);
    }

    public void acceptFood(Integer id)
    {
        List<Food> foods = foodRepository.findAllById(Collections.singleton(id));
        foods.get(0).setStatus(FoodStatus.ACCEPTED);
        foods.get(0).setTaker(taker);
        foodRepository.save(foods.get(0));
    }

    public List<Food> takerHistory()
    {
        return foodRepository.findAllByTakerId(taker.getId());
    }
}

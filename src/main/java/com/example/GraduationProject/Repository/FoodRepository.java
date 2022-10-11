package com.example.GraduationProject.Repository;

import com.example.GraduationProject.Business.Entity.Food;
import com.example.GraduationProject.Business.FoodStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Integer>
{
    List<Food> findAllByDonorId(int id);

    List<Food> findAllByStatus(FoodStatus available);

    List<Food> findAllByTakerId(int id);

    List<Food> findAllByStatusAndPickUpRequired(FoodStatus accepted, boolean b);

    List<Food> findAllByVolunteerId(int id);
}

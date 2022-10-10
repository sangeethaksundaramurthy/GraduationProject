package com.example.GraduationProject.Repository;

import com.example.GraduationProject.Business.Entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Integer>
{
    List<Food> findAllByDonorId(int id);
}

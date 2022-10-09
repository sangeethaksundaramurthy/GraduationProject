package com.example.GraduationProject.Repository;

import com.example.GraduationProject.Business.Entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodItemRepository extends JpaRepository<Food, Integer>
{
}

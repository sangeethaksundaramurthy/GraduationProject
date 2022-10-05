package com.example.GraduationProject.Repository;

import com.example.GraduationProject.Business.Entity.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodItemRepository extends JpaRepository<FoodItem, Integer>
{
}

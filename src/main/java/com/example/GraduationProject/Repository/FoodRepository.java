package com.example.GraduationProject.Repository;

import com.example.GraduationProject.Business.Entity.Food;
import com.example.GraduationProject.Business.FoodStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Integer>
{
    List<Food> findAllByDonorId(int id);

    List<Food> findAllByStatus(FoodStatus available);

    List<Food> findAllByTakerId(int id);

    List<Food> findAllByVolunteerId(int id);
    @Query(value = "select * from food where pick_up_required = 1 and status='ACCEPTED' or pick_up_required = 1 and status='AVAILABLE' and pick_up_date_and_time > getdate() and pick_up_date_and_time < DATEADD(hour,1,GETDATE())\n",
            nativeQuery = true)
    List<Food> foodToBePickedUp();
}

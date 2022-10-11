package com.example.GraduationProject.Repository;

import com.example.GraduationProject.Business.Entity.Taker;
import com.example.GraduationProject.Business.Entity.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VolunteerRepository extends JpaRepository<Volunteer, Integer>
{
    List<Volunteer> findByEmailIdAndPassword(String emailId, String password);

    List<Volunteer> findByEmailId(String emailId);
}

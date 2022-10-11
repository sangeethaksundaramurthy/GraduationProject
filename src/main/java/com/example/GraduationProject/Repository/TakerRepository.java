package com.example.GraduationProject.Repository;

import com.example.GraduationProject.Business.Entity.Taker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TakerRepository extends JpaRepository<Taker, Integer>
{
   List<Taker> findByEmailIdAndPassword(String emailId, String password);

    List<Taker> findByEmailId(String emailId);
}

package com.example.GraduationProject.Repository;

import com.example.GraduationProject.Business.Entity.Donor;
import com.example.GraduationProject.Business.Entity.Taker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DonorRepository extends JpaRepository<Donor, Integer>
{
    List<Donor> findByEmailIdAndPassword(String emailId, String password);
}

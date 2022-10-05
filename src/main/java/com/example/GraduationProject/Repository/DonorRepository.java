package com.example.GraduationProject.Repository;

import com.example.GraduationProject.Business.Entity.Donor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonorRepository extends JpaRepository<Donor, Integer>
{
}

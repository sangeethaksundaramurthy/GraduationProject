package com.example.GraduationProject.Repository;

import com.example.GraduationProject.Business.Entity.Volunteers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VolunteersRepository extends JpaRepository<Volunteers, Integer>
{
}

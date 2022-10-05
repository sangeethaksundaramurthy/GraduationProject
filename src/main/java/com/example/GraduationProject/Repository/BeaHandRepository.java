package com.example.GraduationProject.Repository;

import com.example.GraduationProject.Business.Entity.Taker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeaHandRepository extends JpaRepository<Taker, Integer>
{
}

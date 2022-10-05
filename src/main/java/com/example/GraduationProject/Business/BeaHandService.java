package com.example.GraduationProject.Business;

import com.example.GraduationProject.Business.Entity.Taker;
import com.example.GraduationProject.Repository.BeaHandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BeaHandService
{
    @Autowired
    BeaHandRepository repository;

    public void addTaker(Taker taker)
    {
        repository.save(taker);
    }
}

package com.example.GraduationProject.Business;

import com.example.GraduationProject.Business.Entity.Taker;
import com.example.GraduationProject.Repository.TakerRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;

@Service
@SessionScope
public class TakerService
{
    @Autowired
    TakerRepository repository;

    Taker taker;
    public void save(Taker taker)
    {
        repository.save(taker);
    }

    public Taker authenticate(String emailId, String password)
    {
        List<Taker> takers = repository.findByEmailIdAndPassword(emailId, password);
        if(takers.isEmpty())
            return null;
        else
        {
            taker = takers.get(0);
            return taker;
        }
    }
}

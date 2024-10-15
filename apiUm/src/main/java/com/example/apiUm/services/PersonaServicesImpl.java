package com.example.apiUm.services;

import com.example.apiUm.entities.Persona;
import com.example.apiUm.repositories.BaseRepository;
import com.example.apiUm.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaServicesImpl extends BaseServiceImpl<Persona, Long> implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    public PersonaServicesImpl(BaseRepository<Persona, Long> baseRepository){
        super(baseRepository);
    }
}

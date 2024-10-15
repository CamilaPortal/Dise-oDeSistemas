package com.example.apiUm.repositories;

import com.example.apiUm.entities.Persona;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonaRepository extends BaseRepository<Persona, Long> {
}
package com.example.apiUm.services;

import com.example.apiUm.entities.Autor;
import com.example.apiUm.repositories.AutorRepository;
import com.example.apiUm.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AutorServicesImpl extends BaseServiceImpl<Autor, Long> implements AutorService {
    @Autowired
    private AutorRepository autorRepository;

    public AutorServicesImpl(BaseRepository<Autor, Long> baseRepository) {
        super(baseRepository);
    }
}

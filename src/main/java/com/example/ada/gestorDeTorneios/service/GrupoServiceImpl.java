package com.example.ada.gestorDeTorneios.service;


import com.example.ada.gestorDeTorneios.domain.Grupo;
import com.example.ada.gestorDeTorneios.exceptions.GrupoNotFoundException;
import com.example.ada.gestorDeTorneios.repository.GrupoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GrupoServiceImpl implements GrupoService {

    private final GrupoRepository repository;
    @Override
    public List<Grupo> list() {
        return (List<Grupo>) repository.findAll();
    }

    @Override
    public Grupo save(Grupo grupo) {
        return repository.save(grupo);
    }

    @Override
    public Grupo findById(Long id) {
        return repository.findById(id).orElseThrow(GrupoNotFoundException::new);
    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        repository.deleteById(id);
    }

    @Override
    public Grupo update(Long id, Grupo grupo) {
        if(!repository.existsById(id)){
            throw new GrupoNotFoundException();
        }
        else {
            grupo.setId(id);
            return repository.save(grupo);
        }
    }
}

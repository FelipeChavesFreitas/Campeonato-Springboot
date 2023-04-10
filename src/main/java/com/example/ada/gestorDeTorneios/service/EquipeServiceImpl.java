package com.example.ada.gestorDeTorneios.service;

import com.example.ada.gestorDeTorneios.domain.Equipe;
import com.example.ada.gestorDeTorneios.exceptions.EquipeNotFoundException;
import com.example.ada.gestorDeTorneios.repository.EquipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipeServiceImpl implements EquipeService {

    private final EquipeRepository repository;


    @Override
    public List<Equipe> list() {
        return (List<Equipe>) repository.findAll();
    }

    @Override
    public Equipe save(Equipe equipe) {
        return repository.save(equipe);
    }

    @Override
    public Equipe findById(Long id) {
        return repository.findById(id).orElseThrow(EquipeNotFoundException::new);
    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        repository.deleteById(id);
    }

    @Override
    public Equipe update(Long id, Equipe equipe) {
        if(!repository.existsById(id)){
            throw new EquipeNotFoundException();
        }
        else {
            equipe.setId(id);
            return repository.save(equipe);
        }
    }
}

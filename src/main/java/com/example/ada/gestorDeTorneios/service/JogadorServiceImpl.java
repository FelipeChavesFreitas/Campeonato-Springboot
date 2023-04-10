package com.example.ada.gestorDeTorneios.service;

import com.example.ada.gestorDeTorneios.domain.Jogador;
import com.example.ada.gestorDeTorneios.exceptions.JogadorNotFoundException;
import com.example.ada.gestorDeTorneios.repository.JogadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JogadorServiceImpl implements JogadorService {
    private final JogadorRepository repository;

    @Override
    public List<Jogador> list() {
        return (List<Jogador>) repository.findAll();
    }

    @Override
    public Jogador save(Jogador jogador) {
        return repository.save(jogador);
    }

    @Override
    public Jogador findById(Long id) {
        return repository.findById(id).orElseThrow(JogadorNotFoundException::new);
    }

    @Override
    public void deleteById(Long id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
        } else {
            throw new JogadorNotFoundException();
        }
    }

    @Override
    public Jogador update(Long id, Jogador jogador) {
        if(!repository.existsById(id)) {
            throw new JogadorNotFoundException();
        }
        else{
            jogador.setId(id);
            return repository.save(jogador);
        }
    }
}

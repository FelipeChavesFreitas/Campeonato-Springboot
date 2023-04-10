package com.example.ada.gestorDeTorneios.service;

import com.example.ada.gestorDeTorneios.domain.Torneio;
import com.example.ada.gestorDeTorneios.exceptions.TorneioNotFoundException;
import com.example.ada.gestorDeTorneios.repository.TorneioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class TorneioServiceImpl implements TorneioService {
    private final TorneioRepository repository;
    @Override
    public List<Torneio> list() {
        return (List<Torneio>) repository.findAll();
    }

    @Override
    public Torneio save(Torneio torneio) {
        return repository.save(torneio);
    }

    @Override
    public Torneio findById(Long id) {
        return repository.findById(id).orElseThrow(TorneioNotFoundException::new);
    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        repository.deleteById(id);
    }

    @Override
    public Torneio update(Long id, Torneio torneio) {
        if(!repository.existsById(id)){
            throw new TorneioNotFoundException();
        }
        else {
            torneio.setId(id);
            return repository.save(torneio);
        }
    }
}

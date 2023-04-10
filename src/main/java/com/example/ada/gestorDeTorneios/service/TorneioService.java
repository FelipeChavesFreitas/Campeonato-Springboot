package com.example.ada.gestorDeTorneios.service;

import com.example.ada.gestorDeTorneios.domain.Torneio;

import java.util.List;

public interface TorneioService {
    List<Torneio> list();

    Torneio save(Torneio torneio);

    Torneio findById(Long id);

    void deleteById(Long id);

    Torneio update(Long id, Torneio torneio);
}

package com.example.ada.gestorDeTorneios.service;

import com.example.ada.gestorDeTorneios.domain.Jogador;

import java.util.List;

public interface JogadorService {
    List<Jogador> list();

    Jogador save(Jogador jogador);

    Jogador findById(Long id);

    void deleteById(Long id);

    Jogador update(Long id, Jogador jogador);
}

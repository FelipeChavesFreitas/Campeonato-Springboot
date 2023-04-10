package com.example.ada.gestorDeTorneios.service;

import com.example.ada.gestorDeTorneios.domain.Grupo;
import com.example.ada.gestorDeTorneios.domain.Jogador;

import java.util.List;

public interface GrupoService {
    List<Grupo> list();

    Grupo save(Grupo grupo);

    Grupo findById(Long id);

    void deleteById(Long id);

    Grupo update(Long id, Grupo grupo);
}

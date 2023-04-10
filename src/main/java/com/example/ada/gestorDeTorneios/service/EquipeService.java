package com.example.ada.gestorDeTorneios.service;


import com.example.ada.gestorDeTorneios.domain.Equipe;

import java.util.List;

public interface EquipeService {
    List<Equipe> list();

    Equipe save(Equipe equipe);

    Equipe findById(Long id);

    void deleteById(Long id);

    Equipe update(Long id, Equipe equipe);
}

package com.example.ada.gestorDeTorneios.repository;

import com.example.ada.gestorDeTorneios.domain.Jogador;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogadorRepository extends CrudRepository<Jogador, Long> {
}

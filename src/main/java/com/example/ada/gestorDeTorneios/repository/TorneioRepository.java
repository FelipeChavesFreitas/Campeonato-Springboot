package com.example.ada.gestorDeTorneios.repository;

import com.example.ada.gestorDeTorneios.domain.Equipe;
import com.example.ada.gestorDeTorneios.domain.Torneio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TorneioRepository extends CrudRepository<Torneio, Long> {
}

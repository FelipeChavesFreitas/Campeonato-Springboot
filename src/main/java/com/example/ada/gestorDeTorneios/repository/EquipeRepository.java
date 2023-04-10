package com.example.ada.gestorDeTorneios.repository;

import com.example.ada.gestorDeTorneios.domain.Equipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipeRepository extends CrudRepository<Equipe, Long> {
}

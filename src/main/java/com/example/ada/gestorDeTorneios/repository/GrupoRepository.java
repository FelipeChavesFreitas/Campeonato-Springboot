package com.example.ada.gestorDeTorneios.repository;

import com.example.ada.gestorDeTorneios.domain.Grupo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoRepository extends CrudRepository<Grupo, Long> {
}

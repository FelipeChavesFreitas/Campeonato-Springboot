package com.example.ada.gestorDeTorneios.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Grupo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
    @ManyToOne
    @JsonIgnoreProperties({"equipes", "nome", "premiacao", "grupos" })
    private Torneio torneio;
    @ManyToMany(mappedBy = "grupos")
    private List<Equipe> equipes;


}

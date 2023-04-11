package com.example.ada.gestorDeTorneios.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Torneio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
    private Double premiacao;

    @ManyToMany(mappedBy = "torneios")
    @JsonIgnoreProperties({"torneios", "grupos"})
    private List<Equipe> equipes;

    @OneToMany(mappedBy = "torneio")
    private List<Grupo> grupos;

}

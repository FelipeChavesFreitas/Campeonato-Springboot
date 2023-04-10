package com.example.ada.gestorDeTorneios.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
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
    @Column
    private String nome;
    private Double premiacao;
   // @ManyToMany(mappedBy = "torneios")
    //private List<Equipe> equipes;
    //private List<Grupo> grupos;
}

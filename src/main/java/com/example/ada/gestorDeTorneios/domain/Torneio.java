package com.example.ada.gestorDeTorneios.domain;

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
    @Column
    private String nome;
    private Double premiacao;
    @ManyToMany(mappedBy = "torneios")
    private List<Equipe> equipes;
    @OneToMany(mappedBy = "torneio")
    private List<Grupo> grupos;
   @Override
   public int hashCode() {
       return Objects.hash(id, nome, premiacao);
   }
}

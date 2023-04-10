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
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String nome;
    private String estado;

    @OneToMany(mappedBy = "equipes")
    @JsonIgnoreProperties("equipes")
    private List<Jogador> jogadores;
    @ManyToMany
    @JoinTable(
          name = "time_torneios",
           joinColumns = @JoinColumn(name = "time_id"),
            inverseJoinColumns = @JoinColumn(name = "torneios_id")
     )
    @JsonIgnoreProperties("equipes")
    private List<Torneio> torneios;

}

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
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
    private String estado;

    @OneToMany(mappedBy = "equipe")
    @JsonIgnoreProperties("equipe")
    private List<Jogador> jogadores;

    @ManyToMany
    @JoinTable(
            name = "equipe_torneios",
            joinColumns = @JoinColumn(name = "equipe_id"),
            inverseJoinColumns = @JoinColumn(name = "torneios_id")
    )
    @JsonIgnoreProperties("equipes")
    private List<Torneio> torneios;


}


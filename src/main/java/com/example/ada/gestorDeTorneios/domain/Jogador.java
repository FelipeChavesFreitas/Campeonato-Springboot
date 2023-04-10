package com.example.ada.gestorDeTorneios.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Jogador {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String nome;
    private Long numero;
    @Enumerated(EnumType.STRING)
    private Posicao posicao;

    @ManyToOne
    @JsonIgnoreProperties({"nome", "estado", "jogadores"})
    private Equipe equipe;


    @Override
    public int hashCode() {
        return Objects.hash(id, nome, numero, posicao);
    }
}

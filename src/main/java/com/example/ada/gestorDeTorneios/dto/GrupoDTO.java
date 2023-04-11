package com.example.ada.gestorDeTorneios.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class GrupoDTO {
    @NotBlank(message = "O nome é obrigatório")
    private String nome;
    @NotNull(message = "O Id do Torneio é obrigatório")
    private Long torneioId;
    @NotNull(message = "O Id da Equipe é obrigatório")
    private List<Long> equipeId;
}

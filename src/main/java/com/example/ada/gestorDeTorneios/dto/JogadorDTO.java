package com.example.ada.gestorDeTorneios.dto;

import com.example.ada.gestorDeTorneios.domain.Posicao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class JogadorDTO {
    @NotBlank(message = "O nome Parque Eolico é obrigatório")
    private String nome;
    @NotNull(message = "O número é obrigatório")
    private Long numero;
    @NotNull(message = "A posição é obrigatória")
    private Posicao posicao;
    @NotNull(message = "O Id do Equipe é obrigatório")
    private Long equipeId;
}

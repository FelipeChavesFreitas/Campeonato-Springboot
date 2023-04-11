package com.example.ada.gestorDeTorneios.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
public class TorneioDTO {
    @NotBlank(message = "O nome é obrigatório")
    private String nome;
    @NotNull(message = "A premiação é obrigatória")
    private Double premiacao;
}

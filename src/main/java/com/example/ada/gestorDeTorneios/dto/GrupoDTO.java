package com.example.ada.gestorDeTorneios.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class GrupoDTO {
    @NotBlank(message = "O nome é obrigatório")
    private String nome;
}

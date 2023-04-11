package com.example.ada.gestorDeTorneios.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
@NoArgsConstructor
public class EquipeDTO {
    @NotBlank(message = "O nome é obrigatório")
    private String nome;
    @NotBlank(message = "O Estado é obrigatório")
    private String estado;
    @NotNull(message = "O Id do Torneio é obrigatório")
    private List<Long> TorneioId;


}

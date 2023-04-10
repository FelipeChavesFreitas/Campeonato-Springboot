package com.example.ada.gestorDeTorneios.controller;

import com.example.ada.gestorDeTorneios.domain.Jogador;
import com.example.ada.gestorDeTorneios.domain.Equipe;
import com.example.ada.gestorDeTorneios.dto.JogadorDTO;
import com.example.ada.gestorDeTorneios.service.JogadorService;
import com.example.ada.gestorDeTorneios.service.EquipeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("jogador")
@RestController
public class JogadorController {
    private final JogadorService jogadorService;
    private final EquipeService equipeService;

    @GetMapping
    public List<Jogador> lista(){
        return jogadorService.list();
    }

    @GetMapping("{id}")
    public Jogador getById(@PathVariable Long id) {
        return jogadorService.findById(id);
    }

    @DeleteMapping("{id}")
    public void deleteByID(@PathVariable Long id) {
        jogadorService.deleteById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Jogador save(@Valid @RequestBody JogadorDTO dto) {
        Jogador jogador = Jogador.builder()
                .nome(dto.getNome())
                .numero(dto.getNumero())
                .posicao(dto.getPosicao())
                .build();
        equipeService.findById(dto.getTimeId());
        jogador.setEquipes(Equipe.builder().id(dto.getTimeId()).build());
        return jogadorService.save(jogador);
    }

    @PutMapping("{id}")
    public Jogador update(@PathVariable Long id, @Valid @RequestBody JogadorDTO dto){
        Jogador jogador = Jogador.builder()
                .nome(dto.getNome())
                .numero(dto.getNumero())
                .posicao(dto.getPosicao())
                .build();
        equipeService.findById(dto.getTimeId());
        jogador.setEquipes(Equipe.builder().id(dto.getTimeId()).build());
        return jogadorService.update(id, jogador);
    }
}

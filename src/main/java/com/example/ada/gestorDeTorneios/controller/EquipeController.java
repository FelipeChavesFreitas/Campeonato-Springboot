package com.example.ada.gestorDeTorneios.controller;

import com.example.ada.gestorDeTorneios.domain.Equipe;
import com.example.ada.gestorDeTorneios.dto.EquipeDTO;
import com.example.ada.gestorDeTorneios.service.EquipeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("equipe")
@RestController
public class EquipeController {
    private final EquipeService equipeService;

    @GetMapping
    public List<Equipe> list(){
        return equipeService.list();

    }
    @GetMapping("{id}")
    public Equipe getById(@PathVariable Long id){
        return equipeService.findById(id);
    }

    @DeleteMapping("{id}")
    public void deletById(@PathVariable Long id){
        equipeService.deleteById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Equipe save(@Valid @RequestBody EquipeDTO dto){
        Equipe equipe = Equipe.builder()
                .nome(dto.getNome())
                .estado(dto.getEstado())
                .build();
        return equipeService.save(equipe);
    }

    @PutMapping("{id}")
    public Equipe updateById(@PathVariable Long id, @Valid @RequestBody EquipeDTO dto){
        Equipe equipe = Equipe.builder()
                .nome(dto.getNome())
                .estado(dto.getEstado())
                .build();
        return equipeService.update(id, equipe);
    }
}

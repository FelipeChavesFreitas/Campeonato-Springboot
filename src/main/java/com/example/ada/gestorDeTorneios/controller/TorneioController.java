package com.example.ada.gestorDeTorneios.controller;

import com.example.ada.gestorDeTorneios.domain.Torneio;
import com.example.ada.gestorDeTorneios.dto.TorneioDTO;
import com.example.ada.gestorDeTorneios.service.TorneioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("torneio")
@RestController
public class TorneioController {
    private final TorneioService torneioService;

    @GetMapping
    public List<Torneio> list(){
        return torneioService.list();

    }
    @GetMapping("{id}")
    public Torneio getById(@PathVariable Long id){
        return torneioService.findById(id);
    }

    @DeleteMapping("{id}")
    public void deletById(@PathVariable Long id){
        torneioService.deleteById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Torneio save(@Valid @RequestBody TorneioDTO dto){
        Torneio torneio = Torneio.builder()
                .nome(dto.getNome())
                .premiacao(dto.getPremiacao())
                .build();
        return torneioService.save(torneio);
    }

    @PutMapping("{id}")
    public Torneio updateById(@PathVariable Long id, @Valid @RequestBody TorneioDTO dto){
        Torneio torneio = Torneio.builder()
                .nome(dto.getNome())
                .premiacao(dto.getPremiacao())
                .build();
        return torneioService.update(id, torneio);
    }
}

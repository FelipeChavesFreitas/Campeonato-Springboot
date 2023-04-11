package com.example.ada.gestorDeTorneios.controller;

import com.example.ada.gestorDeTorneios.domain.Equipe;
import com.example.ada.gestorDeTorneios.domain.Grupo;
import com.example.ada.gestorDeTorneios.domain.Torneio;
import com.example.ada.gestorDeTorneios.dto.GrupoDTO;
import com.example.ada.gestorDeTorneios.repository.EquipeRepository;
import com.example.ada.gestorDeTorneios.repository.TorneioRepository;
import com.example.ada.gestorDeTorneios.service.GrupoService;
import com.example.ada.gestorDeTorneios.service.TorneioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RequestMapping("grupo")
@RestController
public class GrupoController {
    private final GrupoService grupoService;
    private final TorneioService torneioService;

    private final EquipeRepository repository;

    @GetMapping
    public List<Grupo> list(){
        return grupoService.list();

    }
    @GetMapping("{id}")
    public Grupo getById(@PathVariable Long id){
        return grupoService.findById(id);
    }

    @DeleteMapping("{id}")
    public void deletById(@PathVariable Long id){
        grupoService.deleteById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Grupo save(@Valid @RequestBody GrupoDTO dto){
        Grupo grupo = Grupo.builder()
                .nome(dto.getNome())
                .build();
        torneioService.findById(dto.getTorneioId());
        grupo.setTorneio(Torneio.builder().id(dto.getTorneioId()).build());
        List<Equipe> listaEquipes = new ArrayList<>();
        for (int i = 0; i < dto.getEquipeId().size(); i++) {
            repository.findById(dto.getEquipeId().get(i));
            listaEquipes.add(Equipe.builder().id(dto.getEquipeId().get(i)).build());
            grupo.setEquipes(listaEquipes);
        }
        return grupoService.save(grupo);
    }

    @PutMapping("{id}")
    public Grupo updateById(@PathVariable Long id, @Valid @RequestBody GrupoDTO dto){
        Grupo grupo = Grupo.builder()
                .nome(dto.getNome())
                .build();
        torneioService.findById(dto.getTorneioId());
        grupo.setTorneio(Torneio.builder().id(dto.getTorneioId()).build());
        List<Equipe> listaEquipes = new ArrayList<>();
        for (int i = 0; i < dto.getEquipeId().size(); i++) {
            repository.findById(dto.getEquipeId().get(i));
            listaEquipes.add(Equipe.builder().id(dto.getEquipeId().get(i)).build());
            grupo.setEquipes(listaEquipes);
        }
        return grupoService.update(id, grupo);
    }
}

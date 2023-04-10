package com.example.ada.gestorDeTorneios.exceptions;

public class EquipeNotFoundException extends RuntimeException {
    public EquipeNotFoundException() {
        super("Equipe não encontrado");
    }
}
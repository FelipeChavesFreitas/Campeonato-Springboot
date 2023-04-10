package com.example.ada.gestorDeTorneios.exceptions;

public class JogadorNotFoundException extends RuntimeException {
    public JogadorNotFoundException(){
        super("Jogador não encontrado");
    }
}

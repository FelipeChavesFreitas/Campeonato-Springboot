package com.example.ada.gestorDeTorneios.exceptions;

public class TorneioNotFoundException extends RuntimeException{
    public TorneioNotFoundException(){
        super("Torneio não encontrado");
    }
}

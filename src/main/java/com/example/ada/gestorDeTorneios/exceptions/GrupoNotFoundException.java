package com.example.ada.gestorDeTorneios.exceptions;

public class GrupoNotFoundException extends RuntimeException{
    public GrupoNotFoundException(){
        super("Grupo não encontrado");
    }
}

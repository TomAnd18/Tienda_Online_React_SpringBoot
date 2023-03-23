package com.tiendaonline.tiendabackend.exception;

public class GameNotFoundException extends RuntimeException{
    public GameNotFoundException(Long id) {
        super("No se encontro un juego con id = " + id);
    }
}

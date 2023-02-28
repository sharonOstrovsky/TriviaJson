package com.example.triviadto.entity;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Juego {

    private ArrayList<Pregunta> preguntas;
    private Usuario usuario;
    private int cantPreguntasPorUsuario; //5


}

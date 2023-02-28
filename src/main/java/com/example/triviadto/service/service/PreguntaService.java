package com.example.triviadto.service.service;

import com.example.triviadto.entity.Pregunta;
import com.example.triviadto.utility.Categoria;

import java.util.ArrayList;

public interface PreguntaService {


    ArrayList<Pregunta> settearPreguntasParaUsuario(int nivel );

    ArrayList<Pregunta> settearPreguntasParaUsuarioNivelNulo();
    ArrayList<Pregunta> obtenerPreguntasPorCategoria(ArrayList<Pregunta> preguntasUsuario, Categoria categoria);


}

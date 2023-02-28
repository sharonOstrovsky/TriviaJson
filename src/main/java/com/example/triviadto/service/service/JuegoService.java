package com.example.triviadto.service.service;

import com.example.triviadto.dto.requestDto.UsuarioRequestDto;
import com.example.triviadto.dto.responseDto.PreguntaResponseDto;
import com.example.triviadto.entity.Pregunta;
import com.example.triviadto.entity.Usuario;
import com.example.triviadto.utility.Categoria;


import java.util.ArrayList;

public interface JuegoService {

    Categoria obtenerCategoriaAzar();
    Pregunta obtenerPreguntaAzar();

    Usuario guardarUsuarioJuego(UsuarioRequestDto usuarioRequestDto);



    ArrayList<PreguntaResponseDto> listarPreguntas();
    void settearPreguntas();

    void eliminarPregunta(Pregunta pregunta);
}

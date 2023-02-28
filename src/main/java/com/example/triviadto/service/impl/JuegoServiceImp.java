package com.example.triviadto.service.impl;


import com.example.triviadto.dto.Mapper.ModelMapperInterface;
import com.example.triviadto.dto.requestDto.UsuarioRequestDto;
import com.example.triviadto.dto.responseDto.PreguntaResponseDto;
import com.example.triviadto.entity.Juego;
import com.example.triviadto.entity.Pregunta;
import com.example.triviadto.entity.Usuario;
import com.example.triviadto.service.service.JuegoService;
import com.example.triviadto.service.service.PreguntaService;
import com.example.triviadto.service.service.UsuarioService;
import com.example.triviadto.utility.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Scanner;

@Service
public class JuegoServiceImp implements JuegoService {

    Juego juego = new Juego();



    PreguntaService preguntaService;


    UsuarioService usuarioService;

    @Autowired
    private ModelMapperInterface modelMapperInterface;

    public JuegoServiceImp(PreguntaService preguntaService, UsuarioService usuarioService) {
        this.preguntaService = preguntaService;
        this.usuarioService = usuarioService;
    }

    @Override
    public Categoria obtenerCategoriaAzar() {
        int numAleatorio = (int)(Math.random() * ((4 - 0) + 1)) + 0;

        switch (numAleatorio){
            case 0:
                return Categoria.geografia;
            case 1:
                return Categoria.matematica;
            case 2:
                return Categoria.tecnologia;
            case 3:
                return Categoria.conocimientoGeneral;
            case 4:
                return Categoria.entretenimiento;
        }
        return null;
    }

    @Override
    public Pregunta obtenerPreguntaAzar() {

        ArrayList<Pregunta> preguntas = preguntaService.obtenerPreguntasPorCategoria(juego.getPreguntas(), obtenerCategoriaAzar());

        int cantPreguntas = preguntas.size();

        int numAleatorio = (int)(Math.random() * ((cantPreguntas-1 - 0) + 1)) + 0;


        return preguntas.get(numAleatorio);
    }



    public ArrayList<PreguntaResponseDto> listarPreguntas(){


        settearPreguntas();

        ArrayList<PreguntaResponseDto> preguntas = new ArrayList<>();

        for(int i = 0; i < 5; i++){
            Pregunta pregunta = obtenerPreguntaAzar();

            preguntas.add(modelMapperInterface.preguntaAPreguntaResDto(pregunta));

            eliminarPregunta(pregunta);

        }

        return preguntas;
    }



    @Override
    public void eliminarPregunta(Pregunta pregunta){

        ArrayList<Pregunta> preguntas = juego.getPreguntas();

        preguntas.remove(pregunta);

        juego.setPreguntas(preguntas);
    }

    @Override
    public void settearPreguntas() {

        int nivel = usuarioService.obtenerNivelPorEdad(juego.getUsuario());
        if(nivel == 0){
            juego.setPreguntas(preguntaService.settearPreguntasParaUsuarioNivelNulo());
        }else{
            juego.setPreguntas(preguntaService.settearPreguntasParaUsuario(nivel));
        }


    }

    @Override
    public Usuario guardarUsuarioJuego(UsuarioRequestDto usuarioRequestDto){
        Usuario usuario= usuarioService.crearUsuario(usuarioRequestDto);
        juego.setUsuario(usuario);
        return usuario;
    }


}

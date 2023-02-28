package com.example.triviadto.dto.Mapper;

import com.example.triviadto.dto.requestDto.PreguntaRequestDto;
import com.example.triviadto.dto.requestDto.UsuarioRequestDto;
import com.example.triviadto.dto.responseDto.PreguntaResponseDto;
import com.example.triviadto.dto.responseDto.UsuarioResponseDto;
import com.example.triviadto.entity.Pregunta;
import com.example.triviadto.entity.Usuario;

public interface ModelMapperInterface {

    Usuario usuarioReqDtoAUsuario(UsuarioRequestDto usuarioRequestDto);

    UsuarioResponseDto usuarioAUsuarioResDto(Usuario usuario);


    Pregunta preguntaReqDtoPregunta(PreguntaRequestDto preguntaRequestDto);

    PreguntaResponseDto preguntaAPreguntaResDto(Pregunta pregunta);
}

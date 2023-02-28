package com.example.triviadto.dto.Mapper;

import com.example.triviadto.dto.requestDto.PreguntaRequestDto;
import com.example.triviadto.dto.requestDto.UsuarioRequestDto;
import com.example.triviadto.dto.responseDto.PreguntaResponseDto;
import com.example.triviadto.dto.responseDto.UsuarioResponseDto;
import com.example.triviadto.entity.Pregunta;
import com.example.triviadto.entity.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ModelMapperImpl implements ModelMapperInterface{

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public Usuario usuarioReqDtoAUsuario(UsuarioRequestDto usuarioRequestDto) {
        return modelMapper.map(usuarioRequestDto,Usuario.class);
    }

    @Override
    public UsuarioResponseDto usuarioAUsuarioResDto(Usuario usuario) {
        return modelMapper.map(usuario,UsuarioResponseDto.class);
    }

    @Override
    public Pregunta preguntaReqDtoPregunta(PreguntaRequestDto preguntaRequestDto) {
        return modelMapper.map(preguntaRequestDto, Pregunta.class);
    }

    @Override
    public PreguntaResponseDto preguntaAPreguntaResDto(Pregunta pregunta) {
        return modelMapper.map(pregunta, PreguntaResponseDto.class);
    }
}

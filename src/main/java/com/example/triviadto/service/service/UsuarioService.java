package com.example.triviadto.service.service;

import com.example.triviadto.dto.requestDto.UsuarioRequestDto;
import com.example.triviadto.dto.responseDto.UsuarioResponseDto;
import com.example.triviadto.entity.Usuario;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UsuarioService {

    int obtenerNivelPorEdad(Usuario usuario);

    ResponseEntity<UsuarioResponseDto> verUsuario(Long id);

    Usuario crearUsuario(UsuarioRequestDto usuarioRequestDto);

    List<Usuario> listarUsuarios();

}

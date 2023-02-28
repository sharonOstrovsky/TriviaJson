package com.example.triviadto.service.impl;


import com.example.triviadto.dto.Mapper.ModelMapperInterface;
import com.example.triviadto.dto.requestDto.UsuarioRequestDto;
import com.example.triviadto.dto.responseDto.UsuarioResponseDto;
import com.example.triviadto.entity.Usuario;
import com.example.triviadto.repository.UsuarioRepository;
import com.example.triviadto.service.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    private ModelMapperInterface modelMapperInterface;


    //pasarlo a switch
    @Override
    public int obtenerNivelPorEdad(Usuario usuario) {

        int edad = usuario.getEdad();

        switch (edad){
            case 1,2,3,4,5,6,7,8,9,10,11,12,13:
                return 1;
            case 14,15,16:
                return 2;
            case 0:
                return 0;
            default:
                return 3;
        }


    }

    /*
    @Override
        public int obtenerNivelPorEdad(Usuario usuario) {
        int edad = usuario.getEdad();

        switch((edad<1) ? 0 : (edad>0 && edad<14) ? 1 : (edad>13 && edad<17) ? 2 : 3){
            case 0:
                return 0;
            case 1 :
                return 1;
            case 2:
                return 2;
            default:
                return 3;
            }
        }
     */

    @Override
    public ResponseEntity<UsuarioResponseDto> verUsuario(Long id) {
        Usuario usuario = usuarioRepository.traer(id);
        return ResponseEntity.status(HttpStatus.OK).body(modelMapperInterface.usuarioAUsuarioResDto(usuario));
    }


    @Override
    public Usuario crearUsuario(UsuarioRequestDto usuarioRequestDto) {

        Usuario usuario = modelMapperInterface.usuarioReqDtoAUsuario(usuarioRequestDto);

       // return usuarioRepository.save(usuario);
        return usuario;
    }

    @Override
    public List<Usuario> listarUsuarios(){
        return usuarioRepository.findAll();
    }
}

package com.example.triviadto.dto.responseDto;

import lombok.Data;

@Data
public class UsuarioResponseDto {

    private  Long id;
    private String nombre;
    private int edad;
    private String telefono;
    private String mail;
}

package com.example.triviadto.dto.requestDto;

import com.example.triviadto.utility.Categoria;
import lombok.Data;

@Data
public class PreguntaRequestDto {

    private Categoria categoria;
    private String descripcion;
    private String opcionA;
    private String opcionB;
    private String opcionC;
    private String opcionD;
    private String opcionCorrecta;
}

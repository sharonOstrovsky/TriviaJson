package com.example.triviadto.controller;

import com.example.triviadto.dto.responseDto.PreguntaResponseDto;
import com.example.triviadto.entity.Juego;
import com.example.triviadto.entity.Pregunta;
import com.example.triviadto.entity.Usuario;
import com.example.triviadto.repository.PreguntaRepository;
import com.example.triviadto.service.impl.JuegoServiceImp;
import com.example.triviadto.service.impl.PreguntaServiceImp;
import com.example.triviadto.service.impl.UsuarioServiceImpl;
import com.example.triviadto.service.service.JuegoService;
import com.example.triviadto.service.service.PreguntaService;
import com.example.triviadto.service.service.UsuarioService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TriviaControllerTest {

    private TestRestTemplate testRestTemplate;

    private PreguntaRepository preguntaRepository;

    Juego juego = new Juego();

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp(){
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }

    @Test
    void listarTodasLosUsuarios() {

        ResponseEntity<Usuario[]> response = testRestTemplate.getForEntity("/api/juego/usuarios", Usuario[].class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response);

        List<Usuario> usuarios = Arrays.asList(response.getBody());
        for (Usuario usuario : usuarios) {
            System.out.println(usuario.toString());
        }
        System.out.println(usuarios.size());
    }


    @Test
    void verUsuario() {

        ResponseEntity<Usuario> response = testRestTemplate.getForEntity("/api/juego/usuarios/1", Usuario.class);
        Assertions.assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        System.out.println(response.getBody());
    }

    @Test
    void crearUsuario() {


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json = """
                {
                    "nombre": "sharon ostrovsky",
                    "edad": 26,
                    "telefono": "1159887252",
                    "mail": "sharon@gmail.com"
                }
                                """;

        HttpEntity<String> request = new HttpEntity<>(json, headers);

        ResponseEntity<Usuario> response = testRestTemplate.exchange("/api/juego/registro", HttpMethod.POST, request, Usuario.class);

        Usuario result = response.getBody();

        juego.setUsuario(result);

        Assertions.assertNotNull(result);
        assertEquals("sharon ostrovsky", result.getNombre());

    }

   // @Test
    void enviarPreguntas() {

        crearUsuario();

        UsuarioService usuarioService = new UsuarioServiceImpl();
        PreguntaService preguntaService = new PreguntaServiceImp(preguntaRepository);
        JuegoService juegoService = new JuegoServiceImp(preguntaService, usuarioService);
        juegoService.settearPreguntas();
        ArrayList<PreguntaResponseDto> preguntas = juegoService.listarPreguntas();

        ResponseEntity<Pregunta> response = testRestTemplate.getForEntity("/api/juego/preguntas", Pregunta.class);
        assertEquals(response, preguntas);
        Assertions.assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        System.out.println(response.getBody());

    }
}
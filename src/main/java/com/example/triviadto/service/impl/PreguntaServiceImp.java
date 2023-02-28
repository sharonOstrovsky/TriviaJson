package com.example.triviadto.service.impl;


import com.example.triviadto.entity.Pregunta;
import com.example.triviadto.repository.PreguntaRepository;
import com.example.triviadto.service.service.PreguntaService;
import com.example.triviadto.utility.Categoria;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


@Service
public class PreguntaServiceImp implements PreguntaService {


    PreguntaRepository preguntaRepository;

    public PreguntaServiceImp(PreguntaRepository preguntaRepository) {
        this.preguntaRepository = preguntaRepository;
    }

    private static final String filePath = "trivia.json";

    public ArrayList<Pregunta> devolverPreguntasJson(){
        ArrayList<Pregunta> preguntas = new ArrayList<>();

        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(filePath));
            JSONArray json = (JSONArray) obj;

            for (int i = 0; i < json.size(); i++) {

                JSONObject object =(JSONObject) json.get(i);


                String id = object.get("id").toString();
                String descripcion = object.get("descripcion").toString();
                String nivel = object.get("nivel").toString();
                String categoria = object.get("categoria").toString();
                String opcionA = object.get("opciona").toString();
                String opcionB = object.get("opcionb").toString();
                String opcionC = object.get("opcionc").toString();
                String opcionD = object.get("opciond").toString();
                String opcionCorrecta = object.get("opcion_correcta").toString();


                preguntas.add(new Pregunta( Long.parseLong(id) , castearCategoria(categoria),Integer.parseInt(nivel), descripcion, opcionA, opcionB, opcionC,opcionD,opcionCorrecta));




            }

        } catch (Exception ex) {
            System.err.println("Error :"+ex.getMessage());



        }


    return preguntas;

    }


    public Categoria castearCategoria(String categoriaString) {

        if (categoriaString.equals("1")){
            return Categoria.conocimientoGeneral;
        } else if (categoriaString.equals("3")) {
            return Categoria.entretenimiento;
        }else if(categoriaString.equals("4")){
            return Categoria.geografia;
        }else if(categoriaString.equals("2")){
            return Categoria.matematica;
        }else if(categoriaString.equals("0")){
            return Categoria.tecnologia;
        }
        return null;
    }

    @Override
    public ArrayList<Pregunta> settearPreguntasParaUsuario(int nivel) {
       // List<Pregunta> preguntas = preguntaRepository.findAll();
        List<Pregunta> preguntas = devolverPreguntasJson();

        ArrayList<Pregunta> preguntasUsuario = new ArrayList<>();

        for (Pregunta pregunta: preguntas) {
            if(pregunta.getNivel() == nivel){
                preguntasUsuario.add(pregunta);
            }
        }

        return preguntasUsuario;
    }

    @Override
    public ArrayList<Pregunta> settearPreguntasParaUsuarioNivelNulo() {

        return (ArrayList<Pregunta>) preguntaRepository.findAll();

    }

    public ArrayList<Pregunta> obtenerPreguntasPorCategoria(ArrayList<Pregunta> preguntasUsuario, Categoria categoria){
        ArrayList<Pregunta> preguntasCategoria = new ArrayList<>();
        for (Pregunta pregunta: preguntasUsuario) {
            if(pregunta.getCategoria().equals(categoria)){
                preguntasCategoria.add(pregunta);

            }
        }

        return preguntasCategoria;
    }

}

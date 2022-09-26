package com.example.jogodavelhaprojeto.repository;

import com.example.jogodavelhaprojeto.model.Resultado;

import java.util.ArrayList;

public class ResultadoRepository {

    private static ResultadoRepository resultadoRepository;

    private ArrayList<Resultado> resultados = new ArrayList<>();

    //implementação do Singleton para que só tenha um repository em todo o projeto
    public static ResultadoRepository getInstance(){
        if(resultadoRepository == null){
            resultadoRepository = new ResultadoRepository();
        }
        return resultadoRepository;
    }

    private ResultadoRepository(){}

    public ArrayList<Resultado> get(){
        return resultados;
    }

    public void save(Resultado resultado){
        resultados.add(resultado);
    }
}

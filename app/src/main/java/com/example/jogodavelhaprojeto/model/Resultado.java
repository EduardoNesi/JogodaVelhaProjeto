package com.example.jogodavelhaprojeto.model;

public class Resultado {

    public Resultado(String tipo_resultado, String nome_vencedor){
        this.tipo_resultado = tipo_resultado;
        this.nome_vencedor = nome_vencedor;
    }

    String tipo_resultado;
    String nome_vencedor;

    public String getNome_vencedor() {
        return nome_vencedor;
    }

    public String getTipo_resultado() {
        return tipo_resultado;
    }
}

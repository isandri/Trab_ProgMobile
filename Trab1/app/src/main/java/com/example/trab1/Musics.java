package com.example.trab1;

import java.io.Serializable;

public class Musics implements Serializable {

    String nome;

    String tempo;
    int animalCapa;

    int somMusica;

    public Musics(String nome, String tempo, int animalCapa, int somMusica) {
        this.nome = nome;
        this.animalCapa = animalCapa;
        this.tempo = tempo;
        this.somMusica = somMusica;
    }

}

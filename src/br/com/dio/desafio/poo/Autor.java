package br.com.dio.desafio.poo;

import java.time.LocalDate;
import java.util.Date;

public abstract class Autor {

    private String nomeAutor;

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }
}

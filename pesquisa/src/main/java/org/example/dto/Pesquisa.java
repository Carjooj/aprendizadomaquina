package org.example.dto;

import java.sql.Date;

public class Pesquisa {
    private String cod_pessoa;

    private String data_coleta;

    private String genero;

    private String data_nascimento;

    private String animal_estimacao;

    private String clima;

    private String bebida_favorita;

    private String hobbies;

    public Pesquisa(String cod_pessoa, String data_coleta, String genero, String data_nascimento, String animal_estimacao, String clima, String bebida_favorita, String hobbies) {
        this.cod_pessoa = cod_pessoa;
        this.data_coleta = data_coleta;
        this.genero = genero;
        this.data_nascimento = data_nascimento;
        this.animal_estimacao = animal_estimacao;
        this.clima = clima;
        this.bebida_favorita = bebida_favorita;
        this.hobbies = hobbies;
    }

    public String getCod_pessoa() {
        return cod_pessoa;
    }

    public void setCod_pessoa(String cod_pessoa) {
        this.cod_pessoa = cod_pessoa;
    }

    public String getData_coleta() {
        return data_coleta;
    }

    public void setData_coleta(String data_coleta) {
        this.data_coleta = data_coleta;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getAnimal_estimacao() {
        return animal_estimacao;
    }

    public void setAnimal_estimacao(String animal_estimacao) {
        this.animal_estimacao = animal_estimacao;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public String getBebida_favorita() {
        return bebida_favorita;
    }

    public void setBebida_favorita(String bebida_favorita) {
        this.bebida_favorita = bebida_favorita;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }
}

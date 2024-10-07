package org.example;

import org.example.database.Conexao;
import org.example.database.Inserir;
import org.example.service.CsvService;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/pesquisas";
        String usuario = "root";
        String senha = "200467lol";

//        CsvService csvService = new CsvService("/home/carjooj/Downloads/BASE_TP");

        Conexao conexao = new Conexao(url, usuario, senha);

        System.out.println(conexao.getConexao());

//        csvService.processarCSV();

        Inserir inserir = new Inserir();

        inserir.popularTabelaAnimalEstimacao(conexao);

    }

}
package org.example;

import java.util.List;

import org.example.database.Conexao;
import org.example.database.Inserir;
import org.example.dto.Pesquisa;
import org.example.service.CsvService;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/pesquisas";
        String usuario = "root";
        String senha = "";

        CsvService csvService = new CsvService("C:\\Users\\dti\\Downloads\\BASE_TP\\BASE_TP");

        Conexao conexao = new Conexao(url, usuario, senha);

        System.out.println(conexao.getConexao());
        
        List<Pesquisa> lista = csvService.processarCSV();

        Inserir inserir = new Inserir();

        inserir.insertAll(conexao, lista);

    }

}
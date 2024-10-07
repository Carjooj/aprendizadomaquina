package org.example.service;


import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import org.example.dto.Pesquisa;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.nio.file.Files.newDirectoryStream;

public class CsvService {

    private String caminhoPasta;

    public CsvService() {}

    public CsvService(String caminho) {
        this.caminhoPasta = caminho;
    }

    public List<Pesquisa> processarCSV(){

        List<Pesquisa> dadosCsv = new ArrayList<>();
        DirectoryStream<Path> listaArquivos;

        try {

            listaArquivos = newDirectoryStream(Paths.get(caminhoPasta), "*.csv");

            //Lendo cada csv setando o caminho no método
            for(Path caminho : listaArquivos){

                //Processando csv
                dadosCsv.addAll(lerCsv(caminho.toString()));

            }

            //Apresentando o csv
//            for(Pesquisa dado : dadosCsv){
//                System.out.println(dado);
//            }

        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        return dadosCsv;

    }

    private List<Pesquisa> lerCsv(String caminhoCSV){

        List<Pesquisa> linhasCSV = new ArrayList<>();

        CSVReader csvReader;

        try{
            //Criando um parser para ler csv com tab
            CSVParser csvParser = new CSVParserBuilder().withSeparator('|').build();
            csvReader = new CSVReaderBuilder(new FileReader(caminhoCSV, StandardCharsets.ISO_8859_1))
                    .withCSVParser(csvParser)
                    .withSkipLines(1)
                    .build();

            String[] linha;

            while((linha = csvReader.readNext()) != null){
                Pesquisa pesquisa = new Pesquisa(linha[0], linha[1], linha[2], linha[3], linha[4], linha[5], linha[6], linha[7]);
                linhasCSV.add(pesquisa);
            }

        }catch (CsvValidationException | IOException e){
            System.out.println(e.getMessage());
        }

       return linhasCSV;
    }

    public String getCaminhoPasta() {
        return caminhoPasta;
    }

    public void setCaminhoPasta(String caminhoPasta) {
        this.caminhoPasta = caminhoPasta;
    }
}

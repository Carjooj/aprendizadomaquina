package org.example.database;

import org.example.dto.Pesquisa;
import org.example.service.CsvService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Inserir {
    private String insertAnimal = "INSERT INTO animal_estimacao (animal) VALUES (?)";
    private String insertBebida = "INSERT INTO bebida VALUES (?)";
    private String insertPessoa = "INSERT INTO pessoa VALUES (?, ?)";
    private String insertPesquisa = "INSERT INTO pesquisa (data_pesquisa) VALUES (?)";
    private String insertClima = "INSERT INTO clima VALUES (?)";
    private String insertHobbie = "INSERT INTO hobbie VALUES (?)";

    CsvService csvService = new CsvService("/home/carjooj/Downloads/BASE_TP");

    public int popularTabelaAnimalEstimacao(Conexao conexao) {
        int id = 0;

        try {
            PreparedStatement statement = conexao.getConexao().prepareStatement(insertAnimal, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, "mamaco");

            statement.execute();

            statement.addBatch();

            try (ResultSet rs = statement.getGeneratedKeys()) {
                if (rs.next()) {
                    id = rs.getInt(1);
                    System.out.println(id);
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return id;
    }
}

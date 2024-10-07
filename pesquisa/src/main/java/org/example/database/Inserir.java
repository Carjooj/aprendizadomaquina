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
    private String insertBebida = "INSERT INTO bebida (bebida) VALUES (?)";
    private String insertPessoa = "INSERT INTO pessoa (genero, data_nascimento) VALUES (?, ?)";
    private String insertPesquisa = "INSERT INTO pesquisa (data_pesquisa, cod_pessoa, cod_animal_estimacao, cod_bebida, cod_hobbie, cod_clima) VALUES (?, ?, ?, ?, ?, ?)";
    private String insertClima = "INSERT INTO clima (clima) VALUES (?)";
    private String insertHobbie = "INSERT INTO hobbie (hobbie) VALUES (?)";

    CsvService csvService = new CsvService("/home/carjooj/Downloads/BASE_TP");

    public int popularTabelaAnimalEstimacao(Conexao conexao, String animal) {
        int id = 0;

        try(PreparedStatement statement = conexao.getConexao().prepareStatement(insertAnimal, Statement.RETURN_GENERATED_KEYS);) {
            
            statement.setString(1, animal);
            statement.execute();

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

    public int popularTabelaBebida(Conexao conexao, String bebida) {
        int id = 0;

        try(PreparedStatement statement = conexao.getConexao().prepareStatement(insertBebida, Statement.RETURN_GENERATED_KEYS);
) {
            
            statement.setString(1, bebida);
            statement.execute();

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
    

    public int popularTabelaPessoa(Conexao conexao, String genero, String data_nascimento) {
        int id = 0;

        try( PreparedStatement statement = conexao.getConexao().prepareStatement(insertPessoa, Statement.RETURN_GENERATED_KEYS);) {
           

            statement.setString(1, genero);
            statement.setDate(2, java.sql.Date.valueOf(data_nascimento));
            statement.execute();

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
    
        public int popularTabelaClima(Conexao conexao, String clima) {
        int id = 0;

        try(PreparedStatement statement = conexao.getConexao().prepareStatement(insertClima, Statement.RETURN_GENERATED_KEYS);) {

            statement.setString(1, clima);
            statement.execute();

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

    public int popularTabelaHobbie(Conexao conexao, String hobbie) {
        int id = 0;

        try(PreparedStatement statement = conexao.getConexao().prepareStatement(insertHobbie, Statement.RETURN_GENERATED_KEYS);) {
            

            statement.setString(1, hobbie);
            statement.execute();

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

    public void popularTabelaPesquisa(Conexao conexao, String data_pesquisa, int cod_pessoa, int cod_animal_estimacao, int cod_bebida, int cod_hobbie, int cod_clima) {
        try(PreparedStatement statement = conexao.getConexao().prepareStatement(insertPesquisa);) {
            statement.setDate(1, java.sql.Date.valueOf(data_pesquisa));
            statement.setInt(2, cod_pessoa);
            statement.setInt(3,cod_animal_estimacao);
            statement.setInt(4, cod_bebida);
            statement.setInt(5, cod_hobbie);
            statement.setInt(6, cod_clima);
            statement.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertAll(Conexao conexao, List<Pesquisa> pesquisas) {
        for (Pesquisa pesquisa : pesquisas) {
            int cod_animal_estimacao = popularTabelaAnimalEstimacao(conexao, pesquisa.getAnimal_estimacao());
            int cod_bebida = popularTabelaBebida(conexao, pesquisa.getBebida_favorita());
            int cod_pessoa = popularTabelaPessoa(conexao, pesquisa.getGenero(), pesquisa.getData_nascimento());
            int cod_clima = popularTabelaClima(conexao, pesquisa.getClima());
            int cod_hobbie = popularTabelaHobbie(conexao, pesquisa.getHobbies());

            popularTabelaPesquisa(conexao, pesquisa.getData_coleta(), cod_pessoa, cod_animal_estimacao, cod_bebida, cod_hobbie, cod_clima);

            System.out.println(conexao);
        }
    }
    
}

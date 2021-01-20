package DAOS;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import JDBC.ConnectionFactory;
import java.sql.Connection;
import JBIN.Passageiro;
import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DAOPassageiro {

    public void adiciona(Passageiro p) {
        String sql = "insert into passageiro "
                + "(nome,nascimento,cpf,dat_Criacao,dat_Mod,senha)" + " values (?,?,?,?,?,?)";
       
            try (Connection connection = new ConnectionFactory().getConnection();
                    PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, p.getNome());
                stmt.setDate(2, java.sql.Date.valueOf(p.getNascimento()));
                stmt.setString(3, p.getDocumento());
                stmt.setDate(4, java.sql.Date.valueOf(p.getDataCriacao()));
                stmt.setDate(5, java.sql.Date.valueOf(p.getDataModificacao()));
                stmt.setString(6, p.getSenha());

                stmt.execute();

                System.out.println("Elemento inserido com sucesso.");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        //na verdade deveria retornar o elemento que foi inserido agora
    }

    public List<Passageiro> lista() {
        String sql = "select * from passageiro";
        List<Passageiro> passageiros = new ArrayList<>();

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Long id = rs.getLong("id");
                String nome = rs.getString("nome");
                java.sql.Date sqlDate = rs.getDate("nascimento");
                String documento = rs.getString("cpf");
                String senha = rs.getString("senha");
                java.sql.Date cria = rs.getDate("dat_Criacao");
                java.sql.Date mod = rs.getDate("dat_Mod");

                LocalDate criacao = cria.toLocalDate();
                LocalDate modifica = mod.toLocalDate();
                LocalDate dat_Nasc = sqlDate.toLocalDate();

                Passageiro p = new Passageiro();
                p.setId(id);
                p.setNome(nome);
                p.setDocumento(documento);
                p.setNascimento(dat_Nasc);
                p.setSenha(senha);
                p.setDataModificacao(criacao);
                p.setDataCriacao(modifica);

                passageiros.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return passageiros;
    }
    
    public Passageiro exclui(Passageiro elemento) {
        String sql = "delete from passageiro where id = ?";

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setLong(1, elemento.getId());
            
            stmt.execute();
            
            System.out.println("Elemento excluído com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return elemento;
    }
}

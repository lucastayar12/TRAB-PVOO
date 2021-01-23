package DAOS;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import JDBC.ConnectionFactory;
import java.sql.Connection;
import JBIN.Companhia_A;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class DAOCompanhia_A {
    
    public int adiciona(Companhia_A co) {
        String sql = "insert into comp_area "
                + "(nome,abreviacao,dat_Criacao,dat_Mod)" + " values (?,?,?,?)";

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, co.getNome());
            stmt.setString(2, co.getAbreviacao());
            stmt.setDate(3, java.sql.Date.valueOf(co.getDataCriacao()));
            stmt.setDate(4, java.sql.Date.valueOf(co.getDataModificacao()));

            stmt.execute();
            
            ResultSet rs = stmt.getGeneratedKeys();

            int retorno = 0;
            if (rs.next()) {
                retorno = rs.getInt(1);
            }
            System.out.println("Elemento inserido com sucesso.");

            return retorno;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

         //na verdade deveria retornar o elemento que foi inserido agora
    }

    public List<Companhia_A> lista() {
        String sql = "select * from comp_area";
        List<Companhia_A> companhias = new ArrayList<>();

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Long id = rs.getLong("id");
                String nome = rs.getString("nome");
                String abreviacao = rs.getString("abreviacao");
                java.sql.Date cria = rs.getDate("dat_Criacao");
                java.sql.Date mod = rs.getDate("dat_Mod");
                
                LocalDate criacao = cria.toLocalDate();
                LocalDate modifica = mod.toLocalDate();

                Companhia_A co = new Companhia_A();
                co.setId(id);
                co.setNome(nome);
                co.setAbreviacao(abreviacao);
                co.setDataModificacao(criacao);
                co.setDataCriacao(modifica);

                companhias.add(co);
                           }
                       } catch (SQLException e) {
                           throw new RuntimeException(e);
                       }
                       return companhias;
                 }
    public void exclui(Companhia_A elemento) {
        String sql = "delete from comp_area where id = ?";

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setLong(1, elemento.getId());

            stmt.execute();

            System.out.println("Elemento excluído com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Long altera(Companhia_A elemento) {
        String sql = "update comp_area set nome = ?,abreviacao = ?, dat_Mod = ? where id = ?";

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, elemento.getNome());
            stmt.setString(2, elemento.getAbreviacao());
            stmt.setDate(3, java.sql.Date.valueOf(elemento.getDataModificacao()));
            stmt.setLong(4, elemento.getId());

            stmt.execute();

            Long retorno = elemento.getId();

            System.out.println("Elemento alterado com sucesso.");
            return retorno;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

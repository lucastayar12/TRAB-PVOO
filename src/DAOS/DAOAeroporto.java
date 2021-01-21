package DAOS;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import JDBC.ConnectionFactory;
import java.sql.Connection;
import JBIN.Aeroporto;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DAOAeroporto {
    
    public int adiciona(Aeroporto aero) {
        String sql = "insert into aeroporto "
                + "(nome,abreviacao,cidade,dat_Criacao,dat_Modificacao)" + " values (?,?,?,?,?)";

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, aero.getNome());
            stmt.setString(2, aero.getAbreviacao());
            stmt.setString(3, aero.getCidade());
            stmt.setDate(4, java.sql.Date.valueOf(aero.getDataCriacao()));
            stmt.setDate(5, java.sql.Date.valueOf(aero.getDataModificacao()));

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

    public List<Aeroporto> lista() {
        String sql = "select * from aeroporto";
        List<Aeroporto> aeroportos = new ArrayList<>();

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Long id = rs.getLong("id");
                String nome = rs.getString("nome");
                String abreviacao = rs.getString("abreviacao");
                String cidade = rs.getString("cidade");
                java.sql.Date cria = rs.getDate("dat_Criacao");
                java.sql.Date mod = rs.getDate("dat_Mod");
                
                LocalDate criacao = cria.toLocalDate();
                LocalDate modifica = mod.toLocalDate();


                Aeroporto aero = new Aeroporto();
                aero.setId(id);
                aero.setNome(nome);
                aero.setAbreviacao(abreviacao);
                aero.setCidade(cidade);
                aero.setDataModificacao(criacao);
                aero.setDataCriacao(modifica);

                aeroportos.add(aero);
                           }
                       } catch (SQLException e) {
                           throw new RuntimeException(e);
                       }
                       return aeroportos;
                 }
    public void exclui(Aeroporto elemento) {
        String sql = "delete from aeroporto where id = ?";

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setLong(1, elemento.getId());

            stmt.execute();

            System.out.println("Elemento excluído com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Long altera(Aeroporto elemento) {
        String sql = "update aeroporto set nome = ?, cidade = ?,abreviacao = ?, dat_Mod = ? where id = ?";

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, elemento.getNome());
            stmt.setString(2, elemento.getCidade());
            stmt.setString(3, elemento.getAbreviacao());
            stmt.setDate(4, java.sql.Date.valueOf(elemento.getDataModificacao()));
            stmt.setLong(5, elemento.getId());

            stmt.execute();

            Long retorno = elemento.getId();

            System.out.println("Elemento alterado com sucesso.");
            return retorno;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

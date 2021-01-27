package DAOS;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import JDBC.ConnectionFactory;
import java.sql.Connection;
import JBIN.Passageiro;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DAOPassageiro {

    public int adiciona(Passageiro p) {
        String sql = "insert into passageiro "
                + "(nome,nascimento,cpf,dat_Criacao,dat_Mod)" + " values (?,?,?,?,?)";

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            stmt.setString(1, p.getNome());
            stmt.setDate(2, java.sql.Date.valueOf(p.getNascimento()));
            stmt.setString(3, p.getDocumento());
            stmt.setDate(4, java.sql.Date.valueOf(p.getDataCriacao()));
            stmt.setDate(5, java.sql.Date.valueOf(p.getDataModificacao()));

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
                p.setDataModificacao(criacao);
                p.setDataCriacao(modifica);

                passageiros.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return passageiros;
    }

    public void exclui(Passageiro elemento) {
        String sql = "delete from passageiro where id = ?";

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setLong(1, elemento.getId());

            stmt.execute();

            System.out.println("Elemento excluído com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Long altera(Passageiro elemento) {
        String sql = "update passageiro set nome = ?, nascimento = ?,cpf = ?, dat_Mod = ?  where id = ?";

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, elemento.getNome());
            stmt.setDate(2, java.sql.Date.valueOf(elemento.getNascimento()));
            stmt.setString(3, elemento.getDocumento());
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
    
    private String criptografa(String original) {
        String senha = null;
        try {
            MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
            byte messageDigest[] = algorithm.digest(original.getBytes("UTF-8"));

            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                hexString.append(String.format("%02X", 0xFF & b));
            }
             senha = hexString.toString();
            
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
           JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
        return senha;
    }
}

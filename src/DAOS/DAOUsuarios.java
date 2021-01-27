/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import JBIN.Passageiro;
import JBIN.Usuario;
import JDBC.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas
 */
public class DAOUsuarios {

    public boolean adiciona(Usuario elemento) {
        String sql = "insert into usuario (login,senha,tipo) values (?,?,?)";

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1, elemento.getLogin());
            stmt.setString(2, elemento.getSenha());
            stmt.setString(3, elemento.getTipo());

            stmt.execute();

            System.out.println("Elemento inserido com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro: " + e.getMessage());
            return false;
        }
        //na verdade deveria retornar o elemento que foi inserido agora
        return true;
    }

    public Usuario localizar(Usuario usuario) {
        String sql = "select * from usuario where login = ? AND senha  = ?";
        Usuario obj = null;
        DAOPassageiro daoPassageiro = new DAOPassageiro();
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, usuario.getSenha());

            try (ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    obj = new Usuario();
                    obj.setId(rs.getLong("id"));
                    obj.setLogin(rs.getString("login"));
                    obj.setSenha(rs.getString("senha"));
                    obj.setTipo(rs.getString("tipo"));
                   
                    return obj;
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());

        }
        return obj;

    }
    
    public List<Usuario> lista() {
        String sql = "select * from usuario";
        Usuario obj = null;
        List<Usuario> users = new ArrayList();
        DAOPassageiro daoPassageiro = new DAOPassageiro();
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {

            try (ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    obj = new Usuario();
                    obj.setId(rs.getLong("id"));
                    obj.setLogin(rs.getString("login"));
                    obj.setSenha(rs.getString("senha"));
                    obj.setTipo(rs.getString("tipo"));

                    List<Passageiro> passageiros = daoPassageiro.lista();
                    for (Passageiro passageiro : passageiros) {

                        if (rs.getLong("passageiro") == passageiro.getId()) {
                            obj.setPassageiro(passageiro);
                            System.out.println(obj.getPassageiro().getNome());
                        }
                    }

                   users.add(obj);
                    
                }
                return users;
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());

        }
        return users;
    }

}

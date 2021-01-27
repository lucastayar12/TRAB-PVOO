package DAOS;

import JBIN.Assento;
import JBIN.Passageiro;
import JBIN.Voo;
import JDBC.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DAOAssento {
    
    public int adiciona(Assento ass) {
        String sql = "insert into assento "
                + "(voo,cod_assento,dat_Criacao,dat_Mod)" + " values (?,?,?,?)";
        
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            stmt.setLong(1, ass.getVoo().getId());
            stmt.setString(2, ass.getCodAssento());
            stmt.setDate(3, java.sql.Date.valueOf(ass.getDataCriacao()));
            stmt.setDate(4, java.sql.Date.valueOf(ass.getDataModificacao()));
            
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
    }
    
    public List<Assento> lista() {
        String sql = "select * from assento";
        List<Assento> assentos = new ArrayList<>();
        
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Long id = rs.getLong("id");
                Long voo = rs.getLong("voo");
                String codAssento = rs.getString("cod_assento");
                Long passageiro = rs.getLong("passageiro");
                java.sql.Date cria = rs.getDate("dat_Criacao");
                java.sql.Date mod = rs.getDate("dat_Mod");
                
                LocalDate criacao = cria.toLocalDate();
                LocalDate modifica = mod.toLocalDate();
                
                DAOVoo dAOVoo = new DAOVoo();
                List<Voo> voos = dAOVoo.lista();
                Voo vo = new Voo();
                
                for (Voo voof : voos) {
                    if (voo == voof.getId()) {
                        vo = voof;
                    }
                    
                }
                
                DAOPassageiro daopassageiro = new DAOPassageiro();
                List<Passageiro> passageiros = daopassageiro.lista();
                Passageiro passageiro1AObject = new Passageiro();
                for (Passageiro passageiro1 : passageiros) {
                    if (passageiro == passageiro1.getId()) {
                        passageiro1AObject = passageiro1;
                    }
                }
                
                Assento lucaschato = new Assento();
                lucaschato.setId(id);
                lucaschato.setPassageiro(passageiro1AObject);
                lucaschato.setCodAssento(codAssento);
                lucaschato.setDataModificacao(modifica);
                lucaschato.setVoo(vo);
                
                assentos.add(lucaschato);
            }
            
        } catch (SQLException e) {
            throw new RuntimeException(e);            
        }     
        return assentos;
    }
    public void exclui(Assento elemento) {
        String sql = "delete from assento where id = ?";
        
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            
            stmt.setLong(1, elemento.getId());
            
            stmt.execute();
            
            System.out.println("Elemento excluído com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    
    }
    
    public Long altera(Assento elemento) {
        String sql = "update assento set voo = ?, cod_assento = ?, dat_Mod = ? where id = ?";
        
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            
            stmt.setLong(1, elemento.getVoo().getId());
            stmt.setString(2, elemento.getCodAssento());
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
    
    public Long alteraP(Assento elemento) {
        String sql = "update assento set passageiro = ?, dat_Mod = ? where id = ?";
        
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            
            stmt.setLong(1, elemento.getPassageiro().getId());
            stmt.setDate(2, java.sql.Date.valueOf(elemento.getDataModificacao()));
            stmt.setLong(3, elemento.getId());
            
            stmt.execute();
            
            Long retorno = elemento.getId();
            
            System.out.println("Elemento alterado com sucesso.");
            return retorno;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

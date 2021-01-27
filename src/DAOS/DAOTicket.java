package DAOS;

import JBIN.Assento;
import JBIN.Passageiro;
import JBIN.Voo;
import JBIN.Ticket;
import JDBC.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DAOTicket {

    public int adiciona(Ticket tic) {
        String sql = "insert into ticket "
                + "(valor,voo,passageiro,dat_Criacao,dat_Mod)" + " values (?,?,?,?,?)";

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setDouble(1, tic.getValor());
            stmt.setLong(2, tic.getVoo().getId());
            stmt.setLong(3, tic.getPassageiro().getId());
            stmt.setDate(4, java.sql.Date.valueOf(tic.getDataCriacao()));
            stmt.setDate(5, java.sql.Date.valueOf(tic.getDataModificacao()));

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

    public List<Ticket> lista() {
        String sql = "select * from ticket";
        List<Ticket> tickets = new ArrayList();

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Long id = rs.getLong("id");
                Double valor = rs.getDouble("valor");
                Long voo = rs.getLong("voo");
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

                Ticket tick = new Ticket();
                tick.setId(id);
                tick.setValor(valor);   
                tick.setVoo(vo);
                tick.setPassageiro(passageiro1AObject);
                tick.setDataModificacao(modifica);
             

                tickets.add(tick);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);            
        }     
        return tickets;
    }
        
       public void exclui(Ticket elemento) {
        String sql = "delete from ticket where id = ?";
        
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            
            stmt.setLong(1, elemento.getId());
            
            stmt.execute();
            
            System.out.println("Elemento excluído com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    
    }
    
       public Long altera(Ticket elemento) {
        String sql = " update ticket set valor =?, voo = ?, passageiro= ?, dat_Mod = ? where id = ?";
        
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            
            stmt.setDouble(1, elemento.getValor());
            stmt.setLong(2, elemento.getVoo().getId());
            stmt.setLong(3, elemento.getPassageiro().getId());
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
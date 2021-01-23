package DAOS;

import JBIN.Aeroporto;
import JBIN.Companhia_A;
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

public class DAOVoo {

    public int adiciona(Voo voo) {
        String sql = "insert into voo "
                + "(origem,destino,data,duracao,comp_area,capacidade,aviao,estado,dat_Criacao,dat_Mod)" + " values (?,?,?,?,?,?,?,?,?,?)";

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setLong(1, voo.getOrigem().getId());
            stmt.setLong(2, voo.getDestino().getId());
            stmt.setDate(3, java.sql.Date.valueOf(voo.getData()));
            stmt.setInt(4, voo.getDuracao());
            stmt.setLong(5, voo.getCompanhia().getId());
            stmt.setLong(6, voo.getCapacidade());
            stmt.setString(7, voo.getAviao());
            stmt.setString(8, voo.getEstado());
            stmt.setDate(9, java.sql.Date.valueOf(voo.getDataCriacao()));
            stmt.setDate(10, java.sql.Date.valueOf(voo.getDataModificacao()));

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

    public List<Voo> lista() {
        String sql = "select * from voo";
        List<Voo> voos = new ArrayList<>();

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Long id = rs.getLong("id");
                Long origem = rs.getLong("origem");
                Long destino = rs.getLong("destino");
                java.sql.Date data = rs.getDate("data");
                int duracao = rs.getInt("duracao");
                Long compA = rs.getLong("comp_area");
                Long capacidade = rs.getLong("capacidade");
                String aviao = rs.getString("aviao");
                String estado = rs.getString("estado");
                java.sql.Date cria = rs.getDate("dat_Criacao");
                java.sql.Date mod = rs.getDate("dat_Mod");

                LocalDate dataf = data.toLocalDate();
                LocalDate criacao = cria.toLocalDate();
                LocalDate modifica = mod.toLocalDate();

                DAOAeroporto daoAeroporto = new DAOAeroporto();
                List<Aeroporto> ars = daoAeroporto.lista();
                Aeroporto aro = new Aeroporto();
                Aeroporto ard = new Aeroporto();
                for (Aeroporto ar : ars) {
                    if (origem == ar.getId()) {
                        aro = ar;
                    }

                    if (destino == ar.getId()) {
                        ard = ar;
                    }
                }

                DAOCompanhia_A daoCompanhiaA = new DAOCompanhia_A();
                List<Companhia_A> companhiaas = daoCompanhiaA.lista();
                Companhia_A companhiaAObject = new Companhia_A();
                 for (Companhia_A companhiaa : companhiaas) {
                    if (compA == companhiaa.getId()) {
                        companhiaAObject = companhiaa;
                    }
                }

                Voo voo = new Voo();
                voo.setId(id);
                voo.setOrigem(aro);
                voo.setDestino(ard);
                voo.setData(dataf);
                voo.setDuracao(duracao);
                voo.setCompanhia(companhiaAObject);
                voo.setCapacidade(capacidade);
                voo.setAviao(aviao);
                voo.setEstado(estado);
                voo.setDataModificacao(criacao);
                voo.setDataCriacao(modifica);

                voos.add(voo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return voos;
    }
    
    public void exclui(Voo elemento) {
        String sql = "delete from voo where id = ?";

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setLong(1, elemento.getId());

            stmt.execute();

            System.out.println("Elemento excluído com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

package domain.dao;

import configuration.JDBCConnection;
import domain.Carro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CarroDAO {

    public static void criar(Carro carro) throws SQLException {
        String sql = "insert into carro (nome,quantidade) values (?,?)";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //cria conexao com o banco
            conn = JDBCConnection.getConnection();

            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setString(1, carro.getNome());
            pstm.setInt(2, carro.getQuantidade());

            pstm.execute();

            System.out.println("Carro salvo com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void deletar(Carro carro) throws SQLException {
        String sql = "delete from carro where id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //cria conexao com o banco
            conn = JDBCConnection.getConnection();

            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setInt(1, carro.getId());

            pstm.execute();

            System.out.println("Carro deletado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

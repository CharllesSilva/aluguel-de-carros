package domain.dao;

import configuration.JDBCConnection;
import domain.Pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PessoaDAO {

    public static void criar(Pessoa pessoa) throws SQLException {
        String sql = "insert into pessoas (nome) values (?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //cria conexao com o banco
            conn = JDBCConnection.getConnection();

            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setString(1, pessoa.getNome());

            pstm.execute();

            System.out.println("Contato salvo com sucesso!");
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

    public static void deletar(Pessoa pessoa) throws SQLException {
        String sql = "delete from pessoas where id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //cria conexao com o banco
            conn = JDBCConnection.getConnection();

            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setInt(1, pessoa.getId());

            pstm.execute();

            System.out.println("Contato deletado com sucesso!");
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

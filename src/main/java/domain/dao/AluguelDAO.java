package domain.dao;

import configuration.JDBCConnection;
import domain.Carro;
import domain.Pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AluguelDAO {

    public static void gerarAluguel(Pessoa pessoa, Carro carro) throws SQLException {
        String sql = "insert into alugueis (id_pessoas,id_carro) values (?,?)";

        String verificaPessoa = "select * from pessoas where id = ? ";
        String verificaCarro = "select * from carro where id = ?";
        Connection conn = null;
        PreparedStatement pstm = null;

        ResultSet rs = null;
        try {
            //cria conexao com o banco
            conn = JDBCConnection.getConnection();

            pstm = conn.prepareStatement(verificaPessoa);
            pstm.setInt(1, pessoa.getId());
            rs = pstm.executeQuery();
            if (!rs.next()) {
                throw new Exception("Cliente não encontrado!");
            }

            pessoa.setNome(rs.getString("nome"));

            pstm = conn.prepareStatement(verificaCarro);
            pstm.setInt(1, carro.getId());
            rs = pstm.executeQuery();
            if (!rs.next()) {
                throw new Exception("Carro não encontrado!");
            }

            carro.setNome(rs.getString("nome"));

            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, pessoa.getId());
            pstm.setInt(2, carro.getId());

            pstm.execute();

            System.out.println("");
            System.out.println("Aluguel feito com sucesso, o cliente " + pessoa.getNome() + " alugou o carro " + carro.getNome());

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

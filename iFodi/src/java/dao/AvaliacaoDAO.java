/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.DatabaseLocator;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Avaliacao;
import model.Pedido;

/**
 *
 * @author Nery
 */
public class AvaliacaoDAO {

    private static AvaliacaoDAO instance = new AvaliacaoDAO();

    private AvaliacaoDAO() {
    }

    public static AvaliacaoDAO getInstance() {
        return instance;
    }

    public void save(String id) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("insert into avaliacao (id)"
                    + "values ('" + id + "')");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public void save(Avaliacao avaliacao) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        String SQL = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            SQL = "insert into avaliacao (id, descricao, votacao, pedido_id) "
                    + "values ('" + avaliacao.getID() + "', '"
                    + avaliacao.getDescricao() + "', '"
                    + avaliacao.getVotacao()
                    + +avaliacao.getPedido().getId() + "')";
            st.execute(SQL);
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public Avaliacao read(Avaliacao avaliacao) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        String stringSQL;
        Avaliacao a = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from avaliacao where id = '" + avaliacao.getID() + "'");
            rs.first();

            a = new Avaliacao(rs.getInt("id"),
                    rs.getString("descricao"),
                    rs.getInt("votacao"),
                    null);

            Pedido pedido = PedidoDAO.getInstance().read(new Pedido(rs.getInt("id")));
            a.setPedido(pedido);
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return a;
    }

    public void delete(Avaliacao avaliacao) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        String stringSQL;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            stringSQL = "delete from Avaliacao where id = '" + avaliacao.getID() + "'";
            st.execute(stringSQL);
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    private void closeResources(Connection conn, Statement st) {
        try {
            if (st != null) {
                st.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
        }
    }
}

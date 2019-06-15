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
import model.FormaPagamento;
import model.Pagamento;
import model.Pedido;

/**
 *
 * @author Nery
 */
public class PagamentoDAO {

    private static PagamentoDAO instance = new PagamentoDAO();

    private PagamentoDAO() {
    }

    public static PagamentoDAO getInstance() {
        return instance;
    }

    public void save(String id) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("insert into pagamento (id)"
                    + "values ('" + id + "')");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public void save(Pagamento pagamento) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        String SQL = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            SQL = "insert into pagamento (id, valor, formaPagamento, pedido_id) "
                    + "values ('" + pagamento.getId() + "', '"
                    + pagamento.getValor() + "', '"
                    + pagamento.getFormaPagamento() + "', '"
                    + pagamento.getPedido().getId() + "')";
            st.execute(SQL);
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public Pagamento read(Pagamento pagamento) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        String stringSQL;
        Pagamento a = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from pagamento where id = '" + pagamento.getId() + "'");
            rs.first();

            a = new Pagamento(rs.getInt("id"),
                    null,
                    rs.getDouble("valor"),
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

    public void delete(Pagamento pagamento) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        String stringSQL;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            stringSQL = "delete from Pagamento where id = '" + pagamento.getId() + "'";
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

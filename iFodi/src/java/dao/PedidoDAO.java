/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controller.ActionFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Cliente;
import model.Pedido;
import model.PedidoStatus;
import model.Restaurante;

/**
 *
 * @author Nery
 */
public class PedidoDAO {

    private static PedidoDAO instance = new PedidoDAO();

    private PedidoDAO() {
    }

    public static PedidoDAO getInstance() {
        return instance;
    }

    public void save(String id) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("insert into pedido (id)"
                    + "values ('" + id + "')");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public void save(Pedido pedido) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        String SQL = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            SQL = "insert into pedido (id, frete, cliente_usuario_email, "
                    + "tempoEstimado, data, restaurante_cnpj, status) "
                    + "values ('" + pedido.getId() + "', '"
                    + pedido.getFrete() + "', '"
                    + pedido.getCliente().getEmail() + "', '"
                    + pedido.getTempoEstimado() + "', '"
                    + pedido.getData() + "', '"
                    + pedido.getRestaurante().getCnpj() + "', '"
                    + pedido.getStatus().getNomeClasse() + "')";

            st.execute(SQL);
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public Pedido read(Pedido pedido) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        String stringSQL;
        Pedido a = null;
        PedidoStatus ps = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from pedido where id = '" + pedido.getId() + "'");
            rs.first();

            a = new Pedido(rs.getInt("id"),
                    rs.getString("data"),
                    rs.getInt("tempoEstimado"));
            a.setFrete(rs.getDouble("tempoEstimado"));
            Cliente cliente = new Cliente(rs.getString("cliente_usuario_email"), null, null);
            Restaurante restaurante = new Restaurante(rs.getString("restaurante_cnpj"));
            a.setRestaurante(RestauranteDAO.getInstance().read(restaurante));
            a.setCliente(ClienteDAO.getInstance().read(cliente));

            String nomeClasse = "model." + rs.getString("status");
            ps = (PedidoStatus) ActionFactory.createPedidoStatus(nomeClasse);
            a.setStatus(ps);
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return a;
    }

    public void edit(Pedido pedido) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        String SQL = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();

            SQL = "update pedido set "
                    + "frete = '" + pedido.getFrete()
                    + "', tempoEstimado = '" + pedido.getTempoEstimado()
                    + "', data = '" + pedido.getData()
                    + "', restaurante_cnpj = '" + pedido.getRestaurante().getCnpj()
                    + "', status = '" + pedido.getStatus().getNomeClasse()
                    + "', cliente_usuario_email = '" + pedido.getCliente().getEmail()
                    + "' where id = " + pedido.getId();

            st.execute(SQL);
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public void delete(Pedido pedido) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        String stringSQL;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            stringSQL = "delete from pedido where id = '" + pedido.getId() + "'";
            st.execute(stringSQL);
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public ArrayList<Pedido> getPedidos() throws ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
        Pedido pedido = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from pedido");
            while (rs.next()) {
                pedido = new Pedido(rs.getInt("id"));
                pedido = read(pedido);
                pedidos.add(pedido);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, st);
        }
        return pedidos;
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

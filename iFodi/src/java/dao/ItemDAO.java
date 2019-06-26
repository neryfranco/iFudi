/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.ItemBuilder;

/**
 *
 * @author Nery
 */
public class ItemDAO {

    private static ItemDAO instance = new ItemDAO();

    private ItemDAO() {
    }

    public static ItemDAO getInstance() {
        return instance;
    }

    public void save(String id) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("insert into item (id)"
                    + "values ('" + id + "')");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public void save(ItemBuilder itemBuilder) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        String SQL = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            SQL = "insert into item (id, quantidade, precoTotal, produto_id, pedido_id) "
                    + "values ('" + itemBuilder.getId() + "', '"
                    + itemBuilder.getQuantidade() + "', '"
                    + itemBuilder.getPrecoTotal() + "', '"
                    + itemBuilder.getProduto().getId() + "', '"
                    + itemBuilder.getPedido().getId() + "')";
            st.execute(SQL);
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public ItemBuilder read(ItemBuilder item) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        String stringSQL;
        ItemBuilder a = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from item where id = '" + item.getId() + "'");
            rs.first();

            a = new ItemBuilder(rs.getInt("id"),
                    null,
                    rs.getInt("quantidade"),
                    rs.getDouble("precoTotal"),
                    null);

            PedidoBuilder pedidoBuilder = PedidoDAO.getInstance().read(new PedidoBuilder(rs.getInt("pedido_id")));
            ProdutoBuilder produto = ProdutoDAO.getInstance().read(new ProdutoBuilder(rs.getInt("produto_id"), null));
            a.setPedido(pedidoBuilder);
            a.setProduto(produto);
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return a;
    }

    public void delete(ItemBuilder itemBuilder) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        String stringSQL;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            stringSQL = "delete from item where id = '" + itemBuilder.getId() + "'";
            st.execute(stringSQL);
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public ArrayList<ItemBuilder> getItemBuilder() throws ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        ArrayList<ItemBuilder> items = new ArrayList<ItemBuilder>();
        ItemBuilder itemBuilder = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from item");
            while (rs.next()) {
                itemBuilder = new ItemBuilder(rs.getInt("id"));
                itemBuilder = read(itemBuilder);
                itemBuilder.add(itemBuilder);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, st);
        }
        return items;
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

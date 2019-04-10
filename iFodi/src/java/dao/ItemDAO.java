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
import model.Item;
import model.Pedido;
import model.Produto;

/**
 *
 * @author Nery
 */
public class ItemDAO {
    
    private static ItemDAO instance = new ItemDAO();
    
    private ItemDAO(){}
    
    public static ItemDAO getInstance(){
        return instance;
    }
    
    public void save (String id) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("insert into item (id)" +
                    "values ('" + id + "')");
        } catch(SQLException e){
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }
    
    public void save(Item item) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        String SQL = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            SQL = "insert into item (id, quantidade, precoTotal, produto_id, pedido_id) " +
                    "values ('" + item.getId() + "', '" 
                    + item.getQuantidade() + "', '" 
                    + item.getPrecoTotal()+ "', '" 
                    + item.getProduto().getID() + "', '" 
                    + item.getPedido().getId() + "')";
            st.execute(SQL);
        } catch(SQLException e){
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }
    
    public Item read(Item item) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        String stringSQL;
        Item a = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from item where id = '" + item.getId()+ "'");
            rs.first();
            
            a = new Item(rs.getInt("id"), 
                    null,
                    rs.getInt("quantidade"),
                    rs.getDouble("precoTotal"),
                    null);
            
            Pedido pedido = PedidoDAO.getInstance().read(new Pedido (rs.getInt("id")));
            Produto produto = ProdutoDAO.getInstance().read(new Produto(rs.getInt("id"), null));
            a.setPedido(pedido);
            a.setProduto(produto);
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return a;
    }
    
    public void delete(Item item) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        String stringSQL;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            stringSQL = "delete from Item where id = '" + item.getId()+ "'";
            st.execute(stringSQL);
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    private void closeResources(Connection conn, Statement st) {
        try{
            if(st!=null) st.close();
            if(conn!=null) conn.close();
        } 
        catch(SQLException e){
        }
    }


}

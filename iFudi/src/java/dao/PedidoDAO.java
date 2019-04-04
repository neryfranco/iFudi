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
import model.Pedido;

/**
 *
 * @author Nery
 */
public class PedidoDAO {
    
    private static PedidoDAO instance = new PedidoDAO();
    
    private PedidoDAO(){}
    
    public static PedidoDAO getInstance(){
        return instance;
    }
    
    public void save (String id) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("insert into pedido (id)" +
                    "values ('" + id + "')");
        } catch(SQLException e){
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
            SQL = "insert into pedido (id, frete_id, cliente_usuario_email, "
                    + "tempoPreparacao, avaliacao_id, data, restaurante_cnpj) " +
                    
                    "values ('" + pedido.getId() + "', '" 
                    + pedido.getFrete().getID() + "', '" 
                    + pedido.getCliente().getEmail() + "', '" 
                    + pedido.getTempoPreparacao() + "', '" 
                    + pedido.getAvaliacao().getID()+ "', '" 
                    + pedido.getData() + "', '" 
                    + pedido.getRestaurante().getCnpj() + "')";
            
            st.execute(SQL);
        } catch(SQLException e){
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
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from pedido where id = '" + pedido.getId()+ "'");
            rs.first();
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return a;
    }
    
    public void delete(Pedido pedido) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        String stringSQL;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            stringSQL = "delete from Pedido where id = '" + pedido.getId()+ "'";
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

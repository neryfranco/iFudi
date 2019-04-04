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
import model.Restaurante;

/**
 *
 * @author Nery
 */
public class RestauranteDAO {
    
    private static RestauranteDAO instance = new RestauranteDAO();
    
    private RestauranteDAO(){}
    
    public static RestauranteDAO getInstance(){
        return instance;
    }
    
    public void save (String cnpj) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("insert into restaurante (id)" +
                    "values ('" + cnpj + "')");
        } catch(SQLException e){
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }
    
    public void save(Restaurante restaurante) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        String SQL = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            SQL = "insert into restaurante (cnpj, nome, rua, numero, cidade, estado, categoria_id, vendedor_usuario_email) "
                    
                    + "values ('" + restaurante.getCnpj()+ "', '" 
                    + restaurante.getNome() + "', '" 
                    + restaurante.getRua() + "', '"
                    + restaurante.getNumero() + "', '" 
                    + restaurante.getCidade() + "', '" 
                    + restaurante.getEstado() + "', '" 
                    + restaurante.getCategoria().getID() + "', '" 
                    + restaurante.getVendedor().getEmail() + "')";
            
            st.execute(SQL);
        } catch(SQLException e){
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }
    
    public Restaurante read(Restaurante restaurante) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        String stringSQL;
        Restaurante a = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from restaurante where cnpj = '" + restaurante.getCnpj()+ "'");
            rs.first();
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return a;
    }
    
    public void delete(Restaurante restaurante) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        String stringSQL;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            stringSQL = "delete from Restaurante where cnpj = '" + restaurante.getCnpj()+ "'";
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

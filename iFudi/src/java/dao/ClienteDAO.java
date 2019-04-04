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
import model.Cliente;

/**
 *
 * @author Nery
 */
public class ClienteDAO {
    
    private static ClienteDAO instance = new ClienteDAO();
    
    private ClienteDAO(){}
    
    public static ClienteDAO getInstance(){
        return instance;
    }
    
    public void save (String email) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("insert into usuario (email)" +
                    "values ('" + email + "')");
            
            st.execute("insert into cliente (email)" +
                    "values ('" + email + "')");
        } catch(SQLException e){
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }
    
    public void save(Cliente cliente) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        String SQL = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            SQL = "insert into usuario (email, senha, nome, cpf, rua, numero, cidade, estado) " +
                    "values ('" + cliente.getEmail()+ "', '" 
                    + cliente.getSenha()+ "', '" 
                    + cliente.getNome()+ "', '" 
                    + cliente.getCpf()+ "', '" 
                    + cliente.getRua()+ "', '" 
                    + cliente.getNumero()+ "', '" 
                    + cliente.getCidade()+ "', '" 
                    + cliente.getEstado() + "')";
            st.execute(SQL);
            
            SQL = "insert into cliente (usuario_email)" +
                    "values ('" + cliente.getEmail();
            st.execute(SQL);
        } catch(SQLException e){
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }
    
    public Cliente read(Cliente cliente) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        String stringSQL;
        Cliente a = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from cliente where usuario_email = '" + cliente.getEmail()+ "'");
            rs.first();
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return a;
    }
    
    public void delete(Cliente cliente) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        String stringSQL;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            stringSQL = "delete from cliente where usuario_email = '" + cliente.getEmail()+ "'";
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

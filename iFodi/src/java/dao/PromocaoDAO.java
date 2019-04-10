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
import model.Promocao;

/**
 *
 * @author Nery
 */
public class PromocaoDAO {
    
    private static PromocaoDAO instance = new PromocaoDAO();
    
    private PromocaoDAO(){}
    
    public static PromocaoDAO getInstance(){
        return instance;
    }
    
    public void save (String id) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("insert into promocao (id)" +
                    "values ('" + id + "')");
        } catch(SQLException e){
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }
    
    public void save(Promocao promocao) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        String SQL = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            SQL = "insert into promocao (id, descricao, porcentagem) "
                    
                    + "values ('" + promocao.getID() + "', '" 
                    + promocao.getDescricao() + "', '" 
                    + promocao.getPorcentagem()+ "')";
            
            st.execute(SQL);
        } catch(SQLException e){
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }
    
    public Promocao read(Promocao promocao) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        String stringSQL;
        Promocao a = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from promocao where id = '" + promocao.getID()+ "'");
            rs.first();
            
            a = new Promocao(rs.getInt("id"), 
                    rs.getString("descricao"),
                    rs.getDouble("porcentagem"));

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return a;
    }
    
    public void delete(Promocao promocao) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        String stringSQL;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            stringSQL = "delete from Promocao where id = '" + promocao.getID()+ "'";
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

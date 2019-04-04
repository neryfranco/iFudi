/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Produto;
import model.Produto;

/**
 *
 * @author Jessica
 */
public class ProdutoDAO {
    
    private static ProdutoDAO instance = new ProdutoDAO();
    
    private ProdutoDAO(){}
    
    public static ProdutoDAO getInstance(){
        return instance;
    }
    
    /*
    public void save (String codigo, String nome) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("insert into produto (nome, codigo)" +
                    "values ('" + nome + "', '" + codigo + "')");
        } catch(SQLException e){
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }*/
    
    public void save(Produto produto) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        String SQL = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            SQL = "insert into produto (codigo, nome, descricao, preco) " +
                    "values ('" + produto.getCodigo() + "', '" 
                    + produto.getNome() + "', '" 
                    + produto.getDescricao() + "', '" 
                    + produto.getPreco() + "')"; 
            st.execute(SQL);
        } catch(SQLException e){
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }
    
    public Produto read(Produto produto) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        String stringSQL;
        Produto a;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from produto where codigo = '" + produto.getCodigo()+ "'");
            rs.first();
            
            a = new Produto(rs.getString("codigo"), 
                    rs.getString("nome"),
                    rs.getString("descricao"),
                    rs.getDouble("preco"));
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return a;
    }
    
    public void delete(Produto produto) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        String stringSQL;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            stringSQL = "delete from Produto where codigo = '" + produto.getCodigo()+ "'";
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

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
import java.util.ArrayList;
import model.Usuario;
import model.Vendedor;

/**
 *
 * @author Nery
 */
public class VendedorDAO {
    
    private static VendedorDAO instance = new VendedorDAO();
    
    private VendedorDAO(){}
    
    public static VendedorDAO getInstance(){
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
            
            st.execute("insert into vendedor (email)" +
                    "values ('" + email + "')");
        } catch(SQLException e){
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }
    
    public void save(Vendedor vendedor) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        String SQL = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            SQL = "insert into usuario (email, senha, nome, cpf, rua, numero, cidade, estado) " +
                    "values ('" + vendedor.getEmail()+ "', '" 
                    + vendedor.getSenha()+ "', '" 
                    + vendedor.getNome()+ "', '" 
                    + vendedor.getCpf()+ "', '" 
                    + vendedor.getRua()+ "', '" 
                    + vendedor.getNumero()+ "', '" 
                    + vendedor.getCidade()+ "', '" 
                    + vendedor.getEstado() + "')";
            st.execute(SQL);
            
            SQL = "insert into vendedor (usuario_email)" +
                    "values ('" + vendedor.getEmail() + "')";
            st.execute(SQL);
        } catch(SQLException e){
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }
    
    public Vendedor read(Vendedor vendedor) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        String stringSQL;
        Vendedor a = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from vendedor where usuario_email = '"  + vendedor.getEmail() + "'");
            rs.first();
            
            Usuario usuario = UsuarioDAO.getInstance().read(new Usuario (rs.getString("usuario_email")));
            a = new Vendedor(usuario.getEmail(),
                    usuario.getSenha(),
                    usuario.getNome());
            a.setCidade(usuario.getCidade());
            a.setComplemento(usuario.getComplemento());
            a.setCpf(usuario.getCpf());
            a.setEstado(usuario.getEstado());
            a.setNumero(usuario.getNumero());
            a.setRua(usuario.getRua());
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return a;
    }
    
    public void delete(Vendedor vendedor) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        String stringSQL;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            stringSQL = "delete from vendedor where usuario_email = '" + vendedor.getEmail()+ "'";
            st.execute(stringSQL);
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }
    
    public ArrayList<Vendedor> getVendedores() throws ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        ArrayList<Vendedor> vendedores = new ArrayList<Vendedor>();
        Vendedor vendedor = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from vendedor");
            while (rs.next()) {
                Usuario usuario = UsuarioDAO.getInstance().read(new Usuario (rs.getString("usuario_email")));
                vendedor = new Vendedor(usuario.getEmail(),
                    usuario.getSenha(),
                    usuario.getNome());
                vendedor.setCidade(usuario.getCidade());
                vendedor.setComplemento(usuario.getComplemento());
                vendedor.setCpf(usuario.getCpf());
                vendedor.setEstado(usuario.getEstado());
                vendedor.setNumero(usuario.getNumero());
                vendedor.setRua(usuario.getRua());
                vendedores.add(vendedor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, st);
        }
        return vendedores;
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

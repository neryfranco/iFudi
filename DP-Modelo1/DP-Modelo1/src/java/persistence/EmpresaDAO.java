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
import java.util.ArrayList;
import java.util.List;
import model.Empresa;

/**
 *
 * @author Jessica
 */
public class EmpresaDAO {
    private static EmpresaDAO instance = new EmpresaDAO();
    
    private EmpresaDAO(){}
    
    public static EmpresaDAO getInstance(){
        return instance;
    }
    
    public void save (String nome, String cnpj) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("insert into empresa (nome, cnpj)" +
                    "values ('" + nome + "', '" + cnpj + "')");
        } catch(SQLException e){
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }
    
    public void save(Empresa empresa) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("insert into empresa (cnpj, nome)" +
                    "values ('" + empresa.getCnpj() + "', '" + empresa.getNome() + "')");
        } catch(SQLException e){
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }
    
    public Empresa read(Empresa empresa) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        String stringSQL;
        Empresa a;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from empresa where cnpj = '" + empresa.getCnpj()+ "'");
            rs.first();
            
            a = new Empresa(rs.getString("nome"), rs.getString("cnpj"));
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return a;
    }
    
    public void delete(Empresa empresa) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        String stringSQL;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            stringSQL = "delete from Empresa where cnpj = '" + empresa.getCnpj()+ "'";
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

    public ArrayList<Empresa> getEmpresas() throws ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        ArrayList<Empresa> empresas = new ArrayList<Empresa>();
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from empresa");
            while (rs.next()) {
                Empresa empresa = new Empresa(rs.getString("cnpj"), rs.getString("nome"));
                empresas.add(empresa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, st);
        }
        return empresas;
    }
    
    public Empresa getEmpresa(String cnpj) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;
        Empresa empresa = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from empresa where cnpj = '" + cnpj + "'");
            rs.first();
            empresa = new Empresa(rs.getString("cnpj"), rs.getString("nome"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, st);
        }
        return empresa;
    }


}

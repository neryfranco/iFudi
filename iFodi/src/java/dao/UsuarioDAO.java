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
import model.UsuarioBuilder;
import model.UsuarioBuilder;

/**
 *
 * @author Nery
 */
public class UsuarioDAO {

    private static UsuarioDAO instance = new UsuarioDAO();

    private UsuarioDAO() {
    }

    public static UsuarioDAO getInstance() {
        return instance;
    }

    public void save(String email) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("insert into usuario (email)"
                    + "values ('" + email + "')");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public void save(Usuario usuario) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        String SQL = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            SQL = "insert into usuario (email, senha, nome, cpf, rua, numero, cidade, estado) "
                    + "values ('" + usuario.getEmail() + "', '"
                    + usuario.getSenha() + "', '"
                    + usuario.getNome() + "', '"
                    + usuario.getCpf() + "', '"
                    + usuario.getRua() + "', '"
                    + usuario.getNumero() + "', '"
                    + usuario.getCidade() + "', '"
                    + usuario.getEstado() + "')";
            st.execute(SQL);
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public Usuario read(Usuario usuario) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        String stringSQL;
        Usuario a = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from usuario where email = '" + usuario.getEmail() + "'");
            rs.first();

           a = new UsuarioBuilder().setEmail(rs.getString("email")).setSenha(rs.getString("senha")).setNome(rs.getString("nome")).setCpf(rs.getString("cpf")).setRua(rs.getString("rua")).setNumero(rs.getString("numero")).setCidade(rs.getString("cidade")).setEstado(rs.getString("estado")).createUsuario();
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return a;
    }

    public void delete(Usuario usuario) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        String stringSQL;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            stringSQL = "delete from usuario where email = '" + usuario.getEmail() + "'";
            st.execute(stringSQL);
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
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

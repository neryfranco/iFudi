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
import java.util.List;
import model.Funcionario;
import model.Usuario;

/**
 *
 * @author Jessica
 */
public class FuncionarioDAO {

    private static FuncionarioDAO instance = new FuncionarioDAO();

    private FuncionarioDAO() {
    }

    public static FuncionarioDAO getInstance() {
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

            st.execute("insert into funcionario (email)"
                    + "values ('" + email + "')");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public void save(Funcionario funcionario) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        String SQL = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            SQL = "insert into usuario (email, senha, nome, funcao) "
                    + "values ('" + funcionario.getEmail() + "', '"
                    + funcionario.getSenha() + "', '"
                    + funcionario.getNome() + "', '"
                    + funcionario.getFuncao() + "')";
            st.execute(SQL);

            SQL = "insert into funcionario (usuario_email)"
                    + "values ('" + funcionario.getEmail() + "')";
            st.execute(SQL);
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public Funcionario read(Funcionario funcionario) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        String stringSQL;
        Funcionario a = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from funcionario where usuario_email = '" + funcionario.getEmail() + "'");
            rs.first();

            Usuario usuario = UsuarioDAO.getInstance().read(new Usuario(rs.getString("usuario_email")));
            a = new Funcionario(usuario.getEmail(),
                    usuario.getSenha(),
                    usuario.getNome(),
                    a.getFuncao());
            a.setCidade(usuario.getCidade());
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

    public void delete(Funcionario funcionario) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        String stringSQL;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            stringSQL = "delete from funcionario where usuario_email = '" + funcionario.getEmail() + "'";
            st.execute(stringSQL);
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public List<Funcionario> obterFuncionarios() throws ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
        Funcionario funcionario = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from funcionario");
            while (rs.next()) {
                funcionario = new Funcionario(rs.getString("usuario_email"), null, null, null);
                funcionario = read(funcionario);
                funcionarios.add(funcionario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, st);
        }
        return funcionarios;
    }

    public Funcionario obterFuncionario(String email) throws ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
        Funcionario funcionario = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from funcionario");
            while (rs.next()) {
                funcionario = new Funcionario(rs.getString("usuario_email"), null, null, null);
                funcionario = read(funcionario);
                funcionarios.add(funcionario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, st);
        }
        return funcionario;
    }

    public List<String> obterFuncao() throws ClassNotFoundException, SQLException {

        Connection conn = null;
        Statement st = null;
        List<String> funcao = new ArrayList();
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select distinct(funcao) from funcionario where status = 'ativo'");
            while (rs.next()) {
                funcao.add(rs.getString("funcao"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, st);
        }
        return funcao;
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

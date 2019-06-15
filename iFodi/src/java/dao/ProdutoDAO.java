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
import model.Produto;
import model.Promocao;
import model.Restaurante;

/**
 *
 * @author Nery
 */
public class ProdutoDAO {

    private static ProdutoDAO instance = new ProdutoDAO();

    private ProdutoDAO() {
    }

    public static ProdutoDAO getInstance() {
        return instance;
    }

    public void save(String id) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("insert into produto (id)"
                    + "values ('" + id + "')");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public void save(Produto produto) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        String SQL = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            SQL = "insert into produto (id, promocao_id, restaurante_cnpj, descricao, preco) "
                    + "values ('" + produto.getId() + "', '"
                    + produto.getPromocao().getId() + "', '"
                    + produto.getRestaurante().getCnpj() + "', '"
                    + produto.getDescricao() + "', '"
                    + produto.getPreco() + "')";

            st.execute(SQL);
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public Produto read(Produto produto) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        String stringSQL;
        Produto a = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from produto where id = '" + produto.getId() + "'");
            rs.first();

            a = new Produto(rs.getInt("id"),
                    rs.getString("descricao"),
                    null);
            Restaurante restaurante = RestauranteDAO.getInstance().read(new Restaurante(rs.getString("restaurante_cnpj")));
            Promocao promocao = PromocaoDAO.getInstance().read(new Promocao(rs.getInt("promocao_id")));
            a.setRestaurante(restaurante);
            a.setPromocao(promocao);
            a.setPreco(rs.getDouble("preco"));
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
            stringSQL = "delete from Produto where id = '" + produto.getId() + "'";
            st.execute(stringSQL);
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public ArrayList<Produto> getProdutos() throws ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        Produto produto = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from produto");
            while (rs.next()) {
                produto = new Produto(rs.getInt("id"), null);
                produto = read(produto);
                produtos.add(produto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, st);
        }
        return produtos;
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

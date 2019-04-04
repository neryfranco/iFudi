/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Produto;
import persistence.ProdutoDAO;

/**
 *
 * @author Nery
 */
public class CadastrarProdutoAction implements Action {

    public CadastrarProdutoAction() {
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String codigo = request.getParameter("textCodigo");
        String nome = request.getParameter("textNome");
        String descricao = request.getParameter("textDescricao");
        Double preco = Double.parseDouble(request.getParameter("textPreco"));
        if (codigo.equals("") || nome.equals("")) {
            response.sendRedirect("gravarProduto.jsp");
        } else {
            Produto produto = new Produto(codigo, nome, descricao, preco);
            try {
                ProdutoDAO.getInstance().save(produto);
                response.sendRedirect("Sucesso.jsp");
            } catch (SQLException ex) {
                response.sendRedirect("Erro.jsp");
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                response.sendRedirect("Erro.jsp");
                ex.printStackTrace();
            }
        }

    }
}

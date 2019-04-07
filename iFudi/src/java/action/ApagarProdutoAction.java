/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import dao.ProdutoDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Produto;

/**
 *
 * @author Jessica
 */
public class ApagarProdutoAction implements Action {
    
    public ApagarProdutoAction(){}

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Double porcentagem = Double.parseDouble(request.getParameter("txtDescricao"));
        String nome = request.getParameter("txtDescricao");

        Produto produto = new Produto(null, nome);
        if (porcentagem.equals("") || nome.equals("")) {
            response.sendRedirect("apagarProduto.jsp");
        } else {
            try {
                Produto p = ProdutoDAO.getInstance().read(produto);
                if (p != null) {
                    ProdutoDAO.getInstance().delete(produto);
                    response.sendRedirect("sucesso.jsp");
                }
            } catch (SQLException ex) {
                response.sendRedirect("erro.jsp");
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }
}

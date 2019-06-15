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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Produto;

/**
 *
 * @author Jessica
 */
public class LerProdutoAction implements Action {

    public LerProdutoAction() {
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Integer id = Integer.parseInt(request.getParameter("txtId"));

        Produto produto = new Produto(id, null);
        if (id.equals("")) {
            response.sendRedirect("lerProduto.jsp");
        } else {
            try {
                Produto p = ProdutoDAO.getInstance().read(produto);
                request.setAttribute("produto", p);
                request.setAttribute("restaurante", p.getRestaurante());
                request.setAttribute("promocao", p.getPromocao());
                RequestDispatcher view = request.getRequestDispatcher("/lerProduto2.jsp");
                view.forward(request, response);
            } catch (SQLException ex) {
                response.sendRedirect("erro.jsp");
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (ServletException ex) {
                Logger.getLogger(LerProdutoAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

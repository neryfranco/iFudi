/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import dao.CategoriaDAO;
import dao.PedidoDAO;
import dao.ProdutoDAO;
import dao.RestauranteDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Categoria;
import model.Pedido;
import model.Produto;
import model.Restaurante;

/**
 *
 * @author Nery
 */
public class PrepararGravarItemAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        ArrayList<Produto> produtos = null;
        ArrayList<Pedido> pedidos = null;
        try {
            produtos = ProdutoDAO.getInstance().getProdutos();
            pedidos = PedidoDAO.getInstance().getPedidos();
            request.setAttribute("produtos", produtos);
            request.setAttribute("pedidos", pedidos);
            RequestDispatcher view = request.getRequestDispatcher("gravarItem.jsp");
            view.forward(request, response);
        } catch (ClassNotFoundException ex) {
            request.setAttribute("restaurante", null);
        } catch (ServletException ex) {
            Logger.getLogger(PrepararGravarItemAction.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}

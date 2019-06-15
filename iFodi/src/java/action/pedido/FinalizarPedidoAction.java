/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.pedido;

import dao.ItemDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Item;
import controller.Action;
import model.PedidoCancelado;

/**
 *
 * @author Nery
 */
import dao.PedidoDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import model.Pedido;

public class FinalizarPedidoAction implements Action {

    public FinalizarPedidoAction() {
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Integer id = Integer.parseInt(request.getParameter("idPedido"));

        Pedido pedido = new Pedido(id, null, null);
        if (id.equals("")) {
            response.sendRedirect("carregarPedidos.jsp");
        } else {
            try {
                Pedido p = PedidoDAO.getInstance().read(pedido);
                if (p != null) {
                    request.setAttribute("msgPedido", p.finalizarPedido());
                    PedidoDAO.getInstance().edit(p);
                    RequestDispatcher view = request.getRequestDispatcher("FrontController?action=action.CarregarPedidosAction");
                    view.forward(request, response);
                }
            } catch (SQLException ex) {
                response.sendRedirect("erro.jsp");
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (ServletException ex) {
                Logger.getLogger(FinalizarPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

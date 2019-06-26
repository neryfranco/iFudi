/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.pedido;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.Action;

/**
 *
 * @author Nery
 */
import dao.PedidoDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import model.PedidoBuilder;

public class CancelarPedidoAction implements Action {

    public CancelarPedidoAction() {
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Integer id = Integer.parseInt(request.getParameter("idPedido"));

        PedidoBuilder pedido = new PedidoBuilder();
        if (id.equals("")) {
            response.sendRedirect("carregarPedidos.jsp");
        } else {
            try {
                PedidoBuilder p = PedidoDAO.getInstance().read(pedido);
                if (p != null) {
                    request.setAttribute("msgPedido", p.cancelarPedido());
                    PedidoDAO.getInstance().edit(p);
                    RequestDispatcher view = request.getRequestDispatcher("FrontController?action=action.CarregarPedidosAction");
                    view.forward(request, response);
                }
            } catch (ServletException ex) {
                Logger.getLogger(CancelarPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

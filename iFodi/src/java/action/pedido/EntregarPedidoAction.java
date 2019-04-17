/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.pedido;

import controller.Action;
import dao.PedidoDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Pedido;

/**
 *
 * @author Nery
 */
public class EntregarPedidoAction implements Action{
    
    public EntregarPedidoAction(){}

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
                    request.setAttribute("msgPedido", p.entregarPedido());
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
                Logger.getLogger(EntregarPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

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
 * @author Jessica
 */
public class LerPedidoAction implements Action {

    public LerPedidoAction() {
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Integer id = Integer.parseInt(request.getParameter("txtId"));

        Pedido pedido = new Pedido(id, null, null);
        if (id.equals("")) {
            response.sendRedirect("lerPedido.jsp");
        } else {
            try {
                Pedido p = PedidoDAO.getInstance().read(pedido);
                request.setAttribute("pedido", p);
                request.setAttribute("avaliacao", p.getAvaliacao());
                request.setAttribute("restaurante", p.getRestaurante());
                request.setAttribute("frete", p.getFrete());
                request.setAttribute("cliente", p.getCliente());
                RequestDispatcher view = request.getRequestDispatcher("/lerPedido2.jsp");
                view.forward(request, response);
            } catch (SQLException ex) {
                response.sendRedirect("erro.jsp");
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (ServletException ex) {
                Logger.getLogger(LerPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

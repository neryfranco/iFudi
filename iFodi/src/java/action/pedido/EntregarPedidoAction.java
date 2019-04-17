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
                    p.entregarPedido();
                    PedidoDAO.getInstance().edit(p);
                    response.sendRedirect("FrontController?action=action.CarregarPedidosAction");
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

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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Pedido;

/**
 *
 * @author Jessica
 */
public class ApagarPedidoAction implements Action {
    
    public ApagarPedidoAction(){}

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Integer votacao = Integer.parseInt(request.getParameter("txtData"));

        Pedido pedido = new Pedido(votacao, null, null);
        if (votacao.equals("")) {
            response.sendRedirect("apagarPedido.jsp");
        } else {
            try {
                Pedido p = PedidoDAO.getInstance().read(pedido);
                if (p != null) {
                    PedidoDAO.getInstance().delete(pedido);
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

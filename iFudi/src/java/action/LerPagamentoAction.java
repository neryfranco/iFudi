/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import dao.PagamentoDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Pagamento;

/**
 *
 * @author Jessica
 */
public class LerPagamentoAction implements Action {
    
    public LerPagamentoAction(){}

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Integer id = Integer.parseInt(request.getParameter("txtId"));
        
        Pagamento pagamento = new Pagamento(id, null);
        if (id.equals("")) {
            response.sendRedirect("lerPagamento.jsp");
        } else {
            try {
                Pagamento p = PagamentoDAO.getInstance().read(pagamento);
                request.setAttribute("pagamento", p);
                request.setAttribute("pedido", p.getPedido());
                RequestDispatcher view = request.getRequestDispatcher("/lerPagamento2.jsp");
                view.forward(request, response);
            } catch (SQLException ex) {
                response.sendRedirect("erro.jsp");
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (ServletException ex) {
                Logger.getLogger(LerPagamentoAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

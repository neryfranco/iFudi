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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Pagamento;

/**
 *
 * @author Jessica
 */
public class ApagarPagamentoAction implements Action {
    
    public ApagarPagamentoAction(){}

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Integer id = Integer.parseInt(request.getParameter("txtId"));
       
        Pagamento pagamento = new Pagamento(id, null);
        if (id.equals("")) {
            response.sendRedirect("apagarPagamento.jsp");
        } else {
            try {
                Pagamento p = PagamentoDAO.getInstance().read(pagamento);
                if (p != null) {
                    PagamentoDAO.getInstance().delete(pagamento);
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

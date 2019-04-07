/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import dao.FreteDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Frete;

/**
 *
 * @author Jessica
 */
public class ApagarFreteAction implements Action {
    
    public ApagarFreteAction(){}

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Double taxa = Double.parseDouble(request.getParameter("txtTaxa"));
        Frete frete = new Frete(null, taxa, null);
        if (taxa.equals("")) {
            response.sendRedirect("apagarFrete.jsp");
        } else {
            try {
                Frete f = FreteDAO.getInstance().read(frete);
                if (f != null) {
                    FreteDAO.getInstance().delete(frete);
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

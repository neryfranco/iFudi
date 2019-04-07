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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Frete;

/**
 *
 * @author Jessica
 */
public class LerFreteAction implements Action {
    
    public LerFreteAction(){}

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Double taxa = Double.parseDouble(request.getParameter("txtTaxa"));
        Frete frete = new Frete(null, taxa, null);
        if (taxa.equals("")) {
            response.sendRedirect("lerFrete.jsp");
        } else {
            try {
                Frete f = FreteDAO.getInstance().read(frete);
                request.setAttribute("frete", f);
                RequestDispatcher view = request.getRequestDispatcher("/lerFrete2.jsp");
                view.forward(request, response);
            } catch (SQLException ex) {
                response.sendRedirect("erro.jsp");
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (ServletException ex) {
                Logger.getLogger(LerFreteAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

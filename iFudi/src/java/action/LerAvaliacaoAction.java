/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import dao.AvaliacaoDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Avaliacao;

/**
 *
 * @author Jessica
 */
public class LerAvaliacaoAction implements Action {
    
    public LerAvaliacaoAction(){}

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Integer id = Integer.parseInt(request.getParameter("txtId"));
        
        Avaliacao avaliacao = new Avaliacao(id, null, null);
        if (id.equals("")) {
            response.sendRedirect("lerAvaliacao.jsp");
        } else {
            try {
                Avaliacao a = AvaliacaoDAO.getInstance().read(avaliacao);
                request.setAttribute("avaliacao", a);
                RequestDispatcher view = request.getRequestDispatcher("/lerAvaliacao2.jsp");
                view.forward(request, response);
            } catch (SQLException ex) {
                response.sendRedirect("erro.jsp");
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (ServletException ex) {
                Logger.getLogger(LerAvaliacaoAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

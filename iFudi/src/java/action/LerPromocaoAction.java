/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import dao.PromocaoDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Promocao;

/**
 *
 * @author Jessica
 */
public class LerPromocaoAction implements Action {

    public LerPromocaoAction() {}

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String descricao = request.getParameter("txtDescricao");
        
        Promocao promocao = new Promocao(null, descricao, null);
        if (descricao.equals("")) {
            response.sendRedirect("lerPromocao.jsp");
        } else {
            try {
                Promocao prom = PromocaoDAO.getInstance().read(promocao);
                request.setAttribute("promocao", prom);
                RequestDispatcher view = request.getRequestDispatcher("/lerPromocao2.jsp");
                view.forward(request, response);
            } catch (SQLException ex) {
                response.sendRedirect("erro.jsp");
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (ServletException ex) {
                Logger.getLogger(LerPromocaoAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

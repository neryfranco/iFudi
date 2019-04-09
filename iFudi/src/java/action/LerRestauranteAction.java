/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import dao.RestauranteDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Restaurante;

/**
 *
 * @author Jessica
 */
public class LerRestauranteAction implements Action {
    
    public LerRestauranteAction(){}

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String cnpj = request.getParameter("txtCnpj");
        
        Restaurante restaurante = new Restaurante(cnpj, null, null, null, null, null);
        if (cnpj.equals("")) {
            response.sendRedirect("lerRestaurante.jsp");
        } else {
            try {
                Restaurante r = RestauranteDAO.getInstance().read(restaurante);
                request.setAttribute("restaurante", r);
                request.setAttribute("categoria", r.getCategoria());
                request.setAttribute("vendedor", r.getVendedor());
                RequestDispatcher view = request.getRequestDispatcher("/lerRestaurante2.jsp");
                view.forward(request, response);
            } catch (SQLException ex) {
                response.sendRedirect("erro.jsp");
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (ServletException ex) {
                Logger.getLogger(LerRestauranteAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

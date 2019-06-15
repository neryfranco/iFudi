/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import dao.CategoriaDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Categoria;

/**
 *
 * @author Jessica
 */
public class LerCategoriaAction implements Action {

    public LerCategoriaAction() {
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Integer id = Integer.parseInt(request.getParameter("txtId"));

        Categoria categoria = new Categoria(id, null);
        if (id.equals("")) {
            response.sendRedirect("lerCategoria.jsp");
        } else {
            try {
                Categoria c = CategoriaDAO.getInstance().read(categoria);
                request.setAttribute("categoria", c);
                RequestDispatcher view = request.getRequestDispatcher("/lerCategoria2.jsp");
                view.forward(request, response);
            } catch (SQLException ex) {
                response.sendRedirect("erro.jsp");
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (ServletException ex) {
                Logger.getLogger(LerCategoriaAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

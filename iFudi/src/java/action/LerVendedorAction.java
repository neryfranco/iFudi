/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import dao.VendedorDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Vendedor;

/**
 *
 * @author Jessica
 */
public class LerVendedorAction implements Action {
    
    public LerVendedorAction(){}

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String nome = request.getParameter("txtNome");
        
        Vendedor vendedor = new Vendedor(null, null, nome);
        if (nome.equals("")) {
            response.sendRedirect("lerVendedor.jsp");
        } else {
            try {
                Vendedor v = VendedorDAO.getInstance().read(vendedor);
                request.setAttribute("vendedor", v);
                RequestDispatcher view = request.getRequestDispatcher("/lerVendedor2.jsp");
                view.forward(request, response);
            } catch (SQLException ex) {
                response.sendRedirect("erro.jsp");
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (ServletException ex) {
                Logger.getLogger(LerVendedorAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

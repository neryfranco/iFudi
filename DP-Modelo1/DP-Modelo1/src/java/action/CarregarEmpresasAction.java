/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Empresa;
import persistence.EmpresaDAO;

/**
 *
 * @author Nery
 */
public class CarregarEmpresasAction implements Action{
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) 
            throws IOException{
        
        ArrayList<Empresa> empresas = null;
        try {
            empresas = EmpresaDAO.getInstance().getEmpresas();
            request.setAttribute("empresas", empresas);
            RequestDispatcher view = request.getRequestDispatcher("gravarContato.jsp");
            view.forward(request, response);
        } catch (ClassNotFoundException ex) {
            request.setAttribute("empresas", null);
        } catch (ServletException ex) {
            Logger.getLogger(CarregarEmpresasAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("gravarContato.jsp");
    
    }
}

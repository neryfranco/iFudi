/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
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
public class LerEmpresaAction implements Action{
 
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String cnpj = request.getParameter("textCnpj");
        Empresa empresa = new Empresa(cnpj, null);
        if(cnpj.equals("")) {
            response.sendRedirect("lerEmpresa.jsp");
        } else{
            try{
                Empresa c = EmpresaDAO.getInstance().read(empresa);
                request.setAttribute("empresa", c);
                RequestDispatcher view=
                    request.getRequestDispatcher("/lerEmpresa2.jsp");
                view.forward(request, response);
            }catch(SQLException ex){
                response.sendRedirect("Erro.jsp");
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (ServletException ex) {
                Logger.getLogger(LerEmpresaAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

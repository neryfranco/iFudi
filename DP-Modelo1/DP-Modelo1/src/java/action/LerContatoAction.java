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
import model.Contato;
import persistence.ContatoDAO;

/**
 *
 * @author Nery
 */
public class LerContatoAction implements Action{
 
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String email = request.getParameter("textEmail");
        Contato contato = new Contato(null, email);
        if(email.equals("")) {
            response.sendRedirect("lerContato.jsp");
        } else{
            try{
                Contato c = ContatoDAO.getInstance().read(contato);
                request.setAttribute("contato", c);
                request.setAttribute("empresa", c.getEmpresa());
                RequestDispatcher view=
                    request.getRequestDispatcher("/lerContato2.jsp");
                view.forward(request, response);
            }catch(SQLException ex){
                response.sendRedirect("Erro.jsp");
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (ServletException ex) {
                Logger.getLogger(LerContatoAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import dao.ClienteDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;

/**
 *
 * @author Jessica
 */
public class LerClienteAction implements Action {
    
    public LerClienteAction(){}

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String nome = request.getParameter("txtNome");
        Cliente cliente = new Cliente(null, null, nome);
        if (nome.equals("")) {
            response.sendRedirect("lerCliente.jsp");
        } else {
            try {
                Cliente c = ClienteDAO.getInstance().read(cliente);
                request.setAttribute("cliente", c);
                RequestDispatcher view = request.getRequestDispatcher("/lerCliente2.jsp");
                view.forward(request, response);
            } catch (SQLException ex) {
                response.sendRedirect("erro.jsp");
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (ServletException ex) {
                Logger.getLogger(LerClienteAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

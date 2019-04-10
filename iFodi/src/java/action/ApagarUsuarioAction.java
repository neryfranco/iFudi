/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import dao.UsuarioDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;

/**
 *
 * @author Jessica

public class ApagarUsuarioAction implements Action {

    public ApagarUsuarioAction(){}
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String email = request.getParameter("txtEmail");
        
        Usuario usuario = new Usuario(email, null, null, null, null, null, null, null);
        if (email.equals("")) {
            response.sendRedirect("apagarUsuario.jsp");
        } else {
            try {
                Usuario us = UsuarioDAO.getInstance().read(usuario);
                if (us != null) {
                    UsuarioDAO.getInstance().delete(usuario);
                    response.sendRedirect("sucesso.jsp");
                }
            } catch (SQLException ex) {
                response.sendRedirect("erro.jsp");
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }
}
 */
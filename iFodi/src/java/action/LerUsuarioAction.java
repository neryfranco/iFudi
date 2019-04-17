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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;

public class LerUsuarioAction implements Action {

    public LerUsuarioAction() {}
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String email = request.getParameter("txtEmail");
        String senha = request.getParameter("txtShenha");
        Usuario usuario = new Usuario(email, senha, null, null, null, null, null, null, null);
        if (email.equals("")) {
            response.sendRedirect("lerUsuario.jsp");
        } else {
            try {
                Usuario u = UsuarioDAO.getInstance().read(usuario);
                request.setAttribute("usuario", u);
                RequestDispatcher view = request.getRequestDispatcher("/lerUsuario2.jsp");
                view.forward(request, response);
            } catch (SQLException ex) {
                response.sendRedirect("erro.jsp");
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (ServletException ex) {
                Logger.getLogger(LerUsuarioAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void logar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
        
        String email = request.getParameter("txtEmail");
        String senha = request.getParameter("txtSenha");
        try {
            Usuario usuario = new Usuario(email, senha);
            RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
            if (usuario != null) {
                String tipo = usuario.getEmail();
                if (tipo.equals("vendedor")) {
                    view = request.getRequestDispatcher("/vendedor.jsp");
                }
                if (tipo.equals("cliente")) {
                    view = request.getRequestDispatcher("/cliente.jsp");
                }
            }
            view.forward(request, response);
        } 
    }
}

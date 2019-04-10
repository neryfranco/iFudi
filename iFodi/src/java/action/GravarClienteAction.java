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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;

/**
 *
 * @author Jessica
 */
public class GravarClienteAction implements Action {

    public GravarClienteAction() {}

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String email = request.getParameter("txtEmail");
        String senha = request.getParameter("txtSenha");
        String nome = request.getParameter("txtNome");

        if (email.equals("") || email.equals("") || nome.equals("")) {
            response.sendRedirect("gravarCliente.jsp");
        } else {
            Cliente cliente = new Cliente(email, senha, nome);
            try {
                ClienteDAO.getInstance().save(cliente);
                response.sendRedirect("sucesso.jsp");
            } catch (SQLException ex) {
                response.sendRedirect("erro.jsp");
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                response.sendRedirect("erro.jsp");
                ex.printStackTrace();
            }
        }
    }

}

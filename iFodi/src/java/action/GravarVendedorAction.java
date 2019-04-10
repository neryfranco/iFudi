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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Vendedor;

/**
 *
 * @author Jessica
 */
public class GravarVendedorAction implements Action {
    
    public GravarVendedorAction(){}

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String email = request.getParameter("txtEmail");
        String senha = request.getParameter("txtSenha");
        String nome = request.getParameter("txtNome");

        if (email.equals("") || email.equals("") || nome.equals("")) {
            response.sendRedirect("gravarVendedor.jsp");
        } else {
            Vendedor vendedor = new Vendedor(email, senha, nome);
            try {
                VendedorDAO.getInstance().save(vendedor);
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

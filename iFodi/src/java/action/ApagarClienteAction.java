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
public class ApagarClienteAction implements Action {

    public ApagarClienteAction() {
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String email = request.getParameter("txtEmail");

        Cliente cliente = new Cliente(email, null, null);
        if (email.equals("")) {
            response.sendRedirect("apagarCliente.jsp");
        } else {
            try {
                Cliente c = ClienteDAO.getInstance().read(cliente);
                if (c != null) {
                    ClienteDAO.getInstance().delete(cliente);
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

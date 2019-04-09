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
public class ApagarVendedorAction implements Action {
    
    public ApagarVendedorAction(){}

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String email = request.getParameter("txtEmail");
        
        Vendedor vendedor = new Vendedor(email, null, null);
        if (email.equals("")) {
            response.sendRedirect("apagarVendedor.jsp");
        } else {
            try {
                Vendedor v = VendedorDAO.getInstance().read(vendedor);
                if (v != null) {
                    VendedorDAO.getInstance().delete(vendedor);
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

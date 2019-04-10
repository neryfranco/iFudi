/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import dao.RestauranteDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Restaurante;

/**
 *
 * @author Jessica
 */
public class ApagarRestauranteAction implements Action {

    public ApagarRestauranteAction() {}

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String cnpj = request.getParameter("txtCnpj");

        Restaurante restaurante = new Restaurante(cnpj, null, null, null, null, null);
        if (cnpj.equals("")) {
            response.sendRedirect("apagarRestaurante.jsp");
        } else {
            try {
                Restaurante r = RestauranteDAO.getInstance().read(restaurante);
                if (r != null) {
                    RestauranteDAO.getInstance().delete(restaurante);
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import dao.CategoriaDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Categoria;

/**
 *
 * @author Jessica
 */
public class GravarCategoriaAction implements Action {

    public GravarCategoriaAction() {
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Integer id = Integer.parseInt(request.getParameter("txtId"));
        String nome = request.getParameter("txtNome");

        if (id.equals("") || nome.equals("")) {
            response.sendRedirect("gravarCategoria.jsp");
        } else {
            Categoria categoria = new Categoria(id, nome);
            try {
                CategoriaDAO.getInstance().save(categoria);
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

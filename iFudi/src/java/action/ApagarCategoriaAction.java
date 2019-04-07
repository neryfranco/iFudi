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
public class ApagarCategoriaAction implements Action {
    
    public ApagarCategoriaAction(){}

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String nome = request.getParameter("txtNome");
        
        Categoria categoria = new Categoria(null, nome);
        if (nome.equals("")) {
            response.sendRedirect("apagarCategoria.jsp");
        } else {
            try {
                Categoria c = CategoriaDAO.getInstance().read(categoria);
                if (c != null) {
                    CategoriaDAO.getInstance().delete(categoria);
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

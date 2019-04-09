/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import dao.PromocaoDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Promocao;

/**
 *
 * @author Jessica
 */
public class ApagarPromocaoAction implements Action {
    
    public ApagarPromocaoAction(){}

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Integer id = Integer.parseInt(request.getParameter("txtId"));
        
        Promocao promocao = new Promocao(id, null, null);
        if (id.equals("")) {
            response.sendRedirect("apagarPromocao.jsp");
        } else {
            try {
                Promocao prom = PromocaoDAO.getInstance().read(promocao);
                if (prom != null) {
                    PromocaoDAO.getInstance().delete(promocao);
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

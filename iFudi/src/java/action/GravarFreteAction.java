/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import dao.FreteDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Frete;

/**
 *
 * @author Jessica
 */
public class GravarFreteAction implements Action {
    
    public GravarFreteAction(){} 

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Integer id = Integer.parseInt(request.getParameter("txtId"));
        Double taxa = Double.parseDouble(request.getParameter("txtTaxa"));
        String tempoEntrega = request.getParameter("txtTempoEntrega");

        if (id.equals("") || taxa.equals("") || tempoEntrega.equals("")) {
            response.sendRedirect("gravarFrete.jsp");
        } else {
            Frete fr = new Frete(id, taxa, tempoEntrega);
            try {
                FreteDAO.getInstance().save(fr);
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

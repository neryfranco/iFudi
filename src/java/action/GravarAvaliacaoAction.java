/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Avaliacao;

/**
 *
 * @author Jessica
 */
public class GravarAvaliacaoAction implements Action {

    public GravarAvaliacaoAction() {
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String codAvaliacao = request.getParameter("textCodAvaliacao");
        String descAvaliacao = request.getParameter("textDescAvaliacao");
        Integer votacao = Integer.parseInt(request.getParameter("textVotacao"));

        if (codAvaliacao.equals("") || descAvaliacao.equals("") || votacao.equals("")) {
            response.sendRedirect("gravarAvaliacao.jsp");
        } else {
            Avaliacao a = new Avaliacao(codAvaliacao, descAvaliacao, votacao);
            try {
                AvaliacaoDAO.getInstance().save(avaliacao);
                response.sendRedirect("sucesso.jsp");
            } catch (SQLException ex) {
                response.sendRedirect("erro.jsp");
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }

}

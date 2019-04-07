/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import dao.AvaliacaoDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Avaliacao;

/**
 *
 * @author Jessica
 */
public class ApagarAvaliacaoAction implements Action {

    public ApagarAvaliacaoAction() {}

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String descricao = request.getParameter("txtDescricao");
        
        Avaliacao avaliacao = new Avaliacao(null, descricao, null);
        if (descricao.equals("")) {
            response.sendRedirect("apagarAvaliacao.jsp");
        } else {
            try {
                Avaliacao a = AvaliacaoDAO.getInstance().read(avaliacao);
                if (a != null) {
                    AvaliacaoDAO.getInstance().delete(avaliacao);
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

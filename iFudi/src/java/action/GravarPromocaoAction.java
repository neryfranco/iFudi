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
public class GravarPromocaoAction implements Action {
    
    public GravarPromocaoAction(){}

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Integer id = Integer.parseInt(request.getParameter("txtId"));
        String descricao = request.getParameter("txtDescricao");
        Double porcentagem = Double.parseDouble(request.getParameter("txtPorcentagem"));

        if (id.equals("") || descricao.equals("") || porcentagem.equals("")) {
            response.sendRedirect("gravarPromocao.jsp");
        } else {
            Promocao promocao = new Promocao(id, descricao, porcentagem);
            try {
                PromocaoDAO.getInstance().save(promocao);
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

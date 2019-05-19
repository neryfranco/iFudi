/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import dao.AvaliacaoDAO;
import dao.PedidoDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Avaliacao;
import model.Pedido;

/**
 *
 * @author Jessica
 */
public class GravarAvaliacaoAction implements Action {

    public GravarAvaliacaoAction() {}

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Integer id = Integer.parseInt(request.getParameter("txtId"));
        String descricao = request.getParameter("txtDescricao");
        Integer votacao = Integer.parseInt(request.getParameter("txtVotacao"));
        Integer pedidoID = Integer.parseInt(request.getParameter("optPedido"));

        if (id.equals("") || descricao.equals("") || votacao.equals("")) {
            response.sendRedirect("gravarAvaliacao.jsp");
        } else {
            try {
                Pedido pedido = PedidoDAO.getInstance().read(new Pedido (pedidoID));
                Avaliacao avaliacao = new Avaliacao(id, descricao, votacao,pedido);
                AvaliacaoDAO.getInstance().save(avaliacao);
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

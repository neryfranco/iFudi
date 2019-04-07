/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import dao.PagamentoDAO;
import dao.PedidoDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Pagamento;
import model.Pedido;

/**
 *
 * @author Jessica
 */
public class GravarPagamentoAction implements Action {
    
    public GravarPagamentoAction(){}

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Integer id = Integer.parseInt(request.getParameter("txtId"));
        Double valor = Double.parseDouble(request.getParameter("txtValor"));
        Integer tempoPreparacao = Integer.parseInt(request.getParameter("optPedido"));

        if (id.equals("") || valor.equals("")) {
            response.sendRedirect("gravarPagamento.jsp");
        } else {
            Pagamento pagamento = new Pagamento(id, valor);
            Pedido pedido = new Pedido(null, null, tempoPreparacao);
            try {
                Pedido pd = PedidoDAO.getInstance().read(pedido);
                pagamento.setPedido(pd);
                PagamentoDAO.getInstance().save(pagamento);
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

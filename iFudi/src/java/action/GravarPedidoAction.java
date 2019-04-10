/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import dao.AvaliacaoDAO;
import dao.ClienteDAO;
import dao.FreteDAO;
import dao.PedidoDAO;
import dao.RestauranteDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Avaliacao;
import model.Cliente;
import model.Frete;
import model.Pedido;
import model.Restaurante;

/**
 *
 * @author Jessica
 */
public class GravarPedidoAction implements Action {
    
    public GravarPedidoAction() {}
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        Integer id = Integer.parseInt(request.getParameter("txtId"));
        String data = request.getParameter("txtData");
        Integer tempoPreparacao = Integer.parseInt(request.getParameter("txtTempoEntrega"));
        Integer votacao = Integer.parseInt(request.getParameter("optAvaliacao"));
        String nome = request.getParameter("optRestaurante");
        Double taxa = Double.parseDouble(request.getParameter("optFrete"));
        String email = request.getParameter("optCliente");
        
        if (id.equals("") || data.equals("") || tempoPreparacao.equals("")) {
            response.sendRedirect("gravarPedido.jsp");
        } else {
            Pedido pedido = new Pedido(id, data, tempoPreparacao);
            Avaliacao avaliacao = new Avaliacao(null, null, votacao);
            Restaurante restaurante = new Restaurante(null, nome, null, null, null, null);
            Frete frete = new Frete(null, taxa, null);
            Cliente cliente = new Cliente(email, null, null);
            try {
                Avaliacao a = AvaliacaoDAO.getInstance().read(avaliacao);
                Restaurante r = RestauranteDAO.getInstance().read(restaurante);
                Frete f = FreteDAO.getInstance().read(frete);
                Cliente c = ClienteDAO.getInstance().read(cliente);
                pedido.setAvaliacao(a);
                pedido.setRestaurante(r);
                pedido.setFrete(f);
                pedido.setCliente(c);
                PedidoDAO.getInstance().save(pedido);
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

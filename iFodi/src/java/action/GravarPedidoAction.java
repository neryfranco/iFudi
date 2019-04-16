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
        Integer tempoEstimado = Integer.parseInt(request.getParameter("txtTempoEntrega"));
        String restaurante_cnpj = request.getParameter("optRestaurante");
        Double frete = Double.parseDouble(request.getParameter("txtFrete"));
        String email = request.getParameter("optCliente");
        
        if (id.equals("") || data.equals("") || tempoEstimado.equals("")) {
            response.sendRedirect("gravarPedido.jsp");
        } else {
            Pedido pedido = new Pedido(id, data, tempoEstimado);
            Restaurante restaurante = new Restaurante(restaurante_cnpj, null, null, null, null, null);
            Cliente cliente = new Cliente(email, null, null);
            try {
                Restaurante r = RestauranteDAO.getInstance().read(restaurante);
                Cliente c = ClienteDAO.getInstance().read(cliente);
                pedido.setRestaurante(r);
                pedido.setCliente(c);
                pedido.setFrete(frete);
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

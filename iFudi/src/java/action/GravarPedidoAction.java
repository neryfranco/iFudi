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
        Integer tempoEntrega = Integer.parseInt(request.getParameter("txtTempoEntrega"));
        Integer votacao = Integer.parseInt(request.getParameter("optAvaliacao"));
        String nome = request.getParameter("optRestaurante");
        Double taxa = Double.parseDouble(request.getParameter("optFrete"));
        String email = request.getParameter("optCleinte");
        
        if (id.equals("") || data.equals("") || tempoEntrega.equals("")) {
            response.sendRedirect("gravarPedido.jsp");
        } else {
            Pedido pd = new Pedido(id, data, tempoEntrega);
            Avaliacao av = new Avaliacao(null, null, votacao);
            Restaurante re = new Restaurante(null, nome, null, null, null, null, null, null, null);
            Frete fr = new Frete(null, taxa, null);
            Cliente cl = new Cliente(email, null, null);
            try {
                Avaliacao ava = AvaliacaoDAO.getInstance().read(av);
                Restaurante r = RestauranteDAO.getInstance().read(re);
                Frete f = FreteDAO.getInstance().read(fr);
                Cliente c = ClienteDAO.getInstance().read(cl);
                pd.setAvaliacao(ava);
                pd.setRestaurante(r);
                pd.setFrete(f);
                pd.setCliente(c);
                PedidoDAO.getInstance().save(pd);
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

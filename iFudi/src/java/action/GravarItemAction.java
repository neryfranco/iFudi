/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import dao.ItemDAO;
import dao.PedidoDAO;
import dao.ProdutoDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Item;
import model.Pedido;
import model.Produto;

/**
 *
 * @author Jessica
 */
public class GravarItemAction implements Action {
    
    public GravarItemAction() {}
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        Integer id = Integer.parseInt(request.getParameter("txtId"));
        Integer quantidade = Integer.parseInt(request.getParameter("txtQtd"));
        Double precoTotal = Double.parseDouble(request.getParameter("txtPrecoTotal"));
        String descricao = request.getParameter("optProduto");
        String data = request.getParameter("optPedido");
        
        if (id.equals("") || quantidade.equals("") || precoTotal.equals("")) {
            response.sendRedirect("gravarItem.jsp");
        } else {
            Item itm = new Item(id, quantidade, precoTotal);
            Produto prd = new Produto(null, descricao, null, null);
            Pedido pdo = new Pedido(null, null, null, data, null, null, null, null, null);
            try {
                Pedido pd = PedidoDAO.getInstance().read(pdo);
                Produto pr = ProdutoDAO.getInstance().read(prd);
                itm.setPedido(pd);
                itm.setProduto(pr);
                ItemDAO.getInstance().save(itm);
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

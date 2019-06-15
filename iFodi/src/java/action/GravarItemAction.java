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

    public GravarItemAction() {
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Integer id = Integer.parseInt(request.getParameter("txtId"));
        Integer quantidade = Integer.parseInt(request.getParameter("txtQtd"));
        Double precoTotal = 0.0;
        Integer produto_id = Integer.parseInt(request.getParameter("optProduto"));
        Integer pedido_id = Integer.parseInt(request.getParameter("optProduto"));

        if (id.equals("") || quantidade.equals("") || precoTotal.equals("")) {
            response.sendRedirect("gravarItem.jsp");
        } else {
            Item item = new Item(id, quantidade, precoTotal);
            Produto produto = new Produto(produto_id, null);
            Pedido pedido = new Pedido(pedido_id);
            try {
                Produto prd = ProdutoDAO.getInstance().read(produto);
                Pedido pdd = PedidoDAO.getInstance().read(pedido);
                item.setProduto(prd);
                item.setPedido(pedido);
                precoTotal = (quantidade * prd.getPreco());
                item.setPrecoTotal(precoTotal);
                ItemDAO.getInstance().save(item);
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

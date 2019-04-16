/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import dao.ProdutoDAO;
import dao.PromocaoDAO;
import dao.RestauranteDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Produto;
import model.Promocao;
import model.Restaurante;

/**
 *
 * @author Jessica
 */
public class GravarProdutoAction implements Action {
    
    public GravarProdutoAction(){}

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Integer id = Integer.parseInt(request.getParameter("txtId"));
        String descricao = request.getParameter("txtDescricao");
        Double preco = Double.parseDouble(request.getParameter("txtPreco"));
        Integer promocao_id = Integer.parseInt(request.getParameter("optPromocao"));
        String restaurante_cnpj = request.getParameter("optRestaurante");

        if (id.equals("") || descricao.equals("")) {
            response.sendRedirect("gravarProduto.jsp");
        } else {
            Produto produto = new Produto(id, descricao);
            Restaurante restaurante = new Restaurante(restaurante_cnpj, null, null, null, null, null);
            Promocao promocao = new Promocao(promocao_id, null, null);
            try {
                Restaurante r = RestauranteDAO.getInstance().read(restaurante);
                Promocao prom = PromocaoDAO.getInstance().read(promocao);
                produto.setPromocao(prom);
                produto.setRestaurante(r);
                produto.setPreco(preco);
                ProdutoDAO.getInstance().save(produto);
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

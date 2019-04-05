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
        Double porcentagem = Double.parseDouble(request.getParameter("optPromocao"));
        String nome = request.getParameter("optRestaurante");

        if (id.equals("") || descricao.equals("")) {
            response.sendRedirect("gravarProduto.jsp");
        } else {
            Produto pr = new Produto(id, descricao);
            Restaurante re = new Restaurante(null, nome, null, null, null, null, null, null, null);
            Promocao pro = new Promocao(null, null, porcentagem);
            try {
                Restaurante r = RestauranteDAO.getInstance().read(re);
                Promocao p = PromocaoDAO.getInstance().read(pro);
                pr.setPromocao(p);
                pr.setRestaurante(r);
                ProdutoDAO.getInstance().save(pr);
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

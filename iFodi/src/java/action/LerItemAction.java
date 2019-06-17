/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import dao.ItemDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Item;
import model.ItemBuilder;

/**
 *
 * @author Jessica
 */
public class LerItemAction implements Action {

    public LerItemAction() {
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Integer id = Integer.parseInt(request.getParameter("txtId"));

        Item item = new ItemBuilder().setId(id).setProduto(null).setQuantidade(null).setPrecoTotal(null).setPedido(null).createItem();
        if (id.equals("")) {
            response.sendRedirect("lerItem.jsp");
        } else {
            try {
                Item i = ItemDAO.getInstance().read(item);
                request.setAttribute("item", i);
                request.setAttribute("produto", i.getProduto());
                request.setAttribute("pedido", i.getPedido());
                RequestDispatcher view = request.getRequestDispatcher("/lerItem2.jsp");
                view.forward(request, response);
            } catch (SQLException ex) {
                response.sendRedirect("erro.jsp");
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (ServletException ex) {
                Logger.getLogger(LerItemAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

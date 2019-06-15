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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Item;

/**
 *
 * @author Jessica
 */
public class ApagarItemAction implements Action {

    public ApagarItemAction() {
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Integer id = Integer.parseInt(request.getParameter("txtId"));

        Item item = new Item(id, null, null);
        if (id.equals("")) {
            response.sendRedirect("apagarItem.jsp");
        } else {
            try {
                Item i = ItemDAO.getInstance().read(item);
                if (i != null) {
                    ItemDAO.getInstance().delete(item);
                    response.sendRedirect("sucesso.jsp");
                }
            } catch (SQLException ex) {
                response.sendRedirect("erro.jsp");
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }
}

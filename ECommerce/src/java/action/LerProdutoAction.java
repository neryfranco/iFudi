/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Produto;
import persistence.ProdutoDAO;

/**
 *
 * @author Nery
 */
public class LerProdutoAction implements Action{
 
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String codigo = request.getParameter("textCodigo");
        Produto produto = new Produto(codigo);
        if(codigo.equals("")) {
            response.sendRedirect("lerProduto.jsp");
        } else{
            try{
                Produto c = ProdutoDAO.getInstance().read(produto);
                request.setAttribute("produto", c);
                RequestDispatcher view=
                    request.getRequestDispatcher("/lerProduto2.jsp");
                view.forward(request, response);
            }catch(SQLException ex){
                response.sendRedirect("Erro.jsp");
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (ServletException ex) {
                Logger.getLogger(LerProdutoAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

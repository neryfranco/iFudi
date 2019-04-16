/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import dao.PromocaoDAO;
import dao.RestauranteDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Promocao;
import model.Restaurante;

/**
 *
 * @author Nery
 */
public class PrepararGravarProdutoAction implements Action{
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) 
            throws IOException{
        
        ArrayList<Promocao> promocoes = null;
        ArrayList<Restaurante> restaurantes = null;
        try {
            promocoes = PromocaoDAO.getInstance().getPromocoes();
            restaurantes = RestauranteDAO.getInstance().getRestaurantes();
            request.setAttribute("promocoes", promocoes);
            request.setAttribute("restaurantes", restaurantes);
            RequestDispatcher view = request.getRequestDispatcher("gravarProduto.jsp");
            view.forward(request, response);
        } catch (ClassNotFoundException ex) {
            request.setAttribute("produto", null);
        } catch (ServletException ex) {
            Logger.getLogger(PrepararGravarProdutoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        //response.sendRedirect("gravarProduto.jsp");
    
    }
}

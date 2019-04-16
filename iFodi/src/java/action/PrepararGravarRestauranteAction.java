/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import dao.CategoriaDAO;
import dao.VendedorDAO;
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
import model.Categoria;
import model.Vendedor;
import model.Restaurante;

/**
 *
 * @author Nery
 */
public class PrepararGravarRestauranteAction implements Action{
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) 
            throws IOException{
        
        ArrayList<Vendedor> vendedores = null;
        ArrayList<Categoria> categorias = null;
        try {
            vendedores = VendedorDAO.getInstance().getVendedores();
            categorias = CategoriaDAO.getInstance().getCategorias();
            request.setAttribute("vendedores", vendedores);
            request.setAttribute("categorias", categorias);
            RequestDispatcher view = request.getRequestDispatcher("gravarRestaurante.jsp");
            view.forward(request, response);
        } catch (ClassNotFoundException ex) {
            request.setAttribute("restaurante", null);
        } catch (ServletException ex) {
            Logger.getLogger(PrepararGravarRestauranteAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import dao.CategoriaDAO;
import dao.ClienteDAO;
import dao.ItemDAO;
import dao.ProdutoDAO;
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
import model.Cliente;
import model.Frete;
import model.Item;
import model.Produto;
import model.Restaurante;

/**
 *
 * @author Nery
 */
public class PrepararGravarPedidoAction implements Action{
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) 
            throws IOException{
        
        ArrayList<Restaurante> restaurantes = null;
        ArrayList<Cliente> clientes = null;
        ArrayList<Item> items = null;
        try {
            restaurantes = RestauranteDAO.getInstance().getRestaurantes();
            clientes = ClienteDAO.getInstance().getClientes();
            items = ItemDAO.getInstance().getItems();
            request.setAttribute("restaurantes", restaurantes);
            request.setAttribute("clientes", clientes);
            request.setAttribute("items", items);
            RequestDispatcher view = request.getRequestDispatcher("gravarPedido.jsp");
            view.forward(request, response);
        } catch (ClassNotFoundException ex) {
            request.setAttribute("restaurante", null);
        } catch (ServletException ex) {
            Logger.getLogger(PrepararGravarPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
}

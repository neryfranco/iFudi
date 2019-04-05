/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import dao.CategoriaDAO;
import dao.RestauranteDAO;
import dao.VendedorDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Categoria;
import model.Restaurante;
import model.Vendedor;

/**
 *
 * @author Jessica
 */
public class GravarRestauranteAction implements Action {
    
    public GravarRestauranteAction(){}

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String cnpj = request.getParameter("txtCnpj");
        String nome = request.getParameter("txtNome");
        String rua = request.getParameter("txtRua");
        String numero = request.getParameter("txtNumero");
        String cidade = request.getParameter("txtCidade");
        String estado = request.getParameter("txtEstado");
        Integer id = Integer.parseInt(request.getParameter("optCategoria"));
        String email = request.getParameter("optVendedor");

        if (cnpj.equals("") || nome.equals("") || rua.equals("") || numero.equals("") || cidade.equals("") || estado.equals("")) {
            response.sendRedirect("gravarRestaurante.jsp");
        } else {
            Restaurante re = new Restaurante(cnpj, nome, rua, numero, cidade, estado);
            Categoria ca = new Categoria(id, null);
            Vendedor ve = new Vendedor(email, null, null);
            try {
                Categoria c = CategoriaDAO.getInstance().read(ca);
                Vendedor v = VendedorDAO.getInstance().read(ve);
                re.setCategoria(c);
                re.setVendedor(v);
                RestauranteDAO.getInstance().save(re);
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

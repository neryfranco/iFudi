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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Contato;
import model.Empresa;
import persistence.ContatoDAO;
import persistence.EmpresaDAO;

/**
 *
 * @author Nery
 */
public class GravarContatoAction implements Action {

    public GravarContatoAction() {
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String nome = request.getParameter("textNome");
        String email = request.getParameter("textEmail");
        String CNPJ = request.getParameter("optEmpresa");
        if (nome.equals("") || email.equals("")) {
            response.sendRedirect("gravarContato.jsp");
        } else {
            Contato contato = new Contato(nome, email);
            Empresa empresa = new Empresa(CNPJ, null);
            try {
                Empresa e = EmpresaDAO.getInstance().read(empresa);
                contato.setEmpresa(empresa);
                ContatoDAO.getInstance().save(contato);
                response.sendRedirect("Sucesso.jsp");
            } catch (SQLException ex) {
                response.sendRedirect("Erro.jsp");
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                response.sendRedirect("Erro.jsp");
                ex.printStackTrace();
            }
        }

    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import dao.UsuarioDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;

/**
 *
 * @author Jessica

public class GravarUsuarioAction implements Action {
    
    public GravarUsuarioAction(){}

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String email = request.getParameter("txtEmail");
        String senha = request.getParameter("txtSenha");
        String nome = request.getParameter("txtNome");
        String cpf = request.getParameter("txtCpf");
        String rua = request.getParameter("txtRua");
        String numero = request.getParameter("txtNumero");
        String cidade = request.getParameter("txtCidade");
        String estado = request.getParameter("txtEstado");

        if (email.equals("") || senha.equals("") || nome.equals("") || cpf.equals("") || rua.equals("") || numero.equals("") || cidade.equals("") || estado.equals("")) {
            response.sendRedirect("gravarUsuario.jsp");
        } else {
            Usuario usuario = new Usuario(email, senha, nome, cpf, rua, numero, cidade, estado);
            try {
                UsuarioDAO.getInstance().save(usuario);
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

 */
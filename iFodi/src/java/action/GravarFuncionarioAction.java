/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import dao.FuncionarioDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Funcionario;

/**
 *
 * @author Jessica
 */
public class GravarFuncionarioAction implements Action{
    
     public GravarFuncionarioAction() {}

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String email = request.getParameter("txtEmail");
        String senha = request.getParameter("txtSenha");
        String nome = request.getParameter("txtNome");
        String funcao = request.getParameter("txtFuncao");
        String status = request.getParameter("txtStatus");

        if (email.equals("") || email.equals("") || nome.equals("") || funcao.equals("")) {
            response.sendRedirect("gravarFuncionario.jsp");
        } else {
            Funcionario funcionario= new Funcionario(email, senha, nome, funcao);
            try {
                FuncionarioDAO.getInstance().save(funcionario);
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

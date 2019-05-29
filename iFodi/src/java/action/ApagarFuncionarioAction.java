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
public class ApagarFuncionarioAction implements Action{
    
     public ApagarFuncionarioAction(){}

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

         String email = request.getParameter("txtEmail");
        
        Funcionario funcionario = new Funcionario(email, null, null, null);
        if (email.equals("")) {
            response.sendRedirect("apagarFuncionario.jsp");
        } else {
            try {
                Funcionario c = FuncionarioDAO.getInstance().read(funcionario);
                if (c != null) {
                    FuncionarioDAO.getInstance().delete(funcionario);
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

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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Funcionario;

/**
 *
 * @author Jessica
 */
public class LerFuncionarioAction implements Action {

    public LerFuncionarioAction() {}

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String email = request.getParameter("txtEmail");

        Funcionario funcionario = new Funcionario(email, null, null, null);
        if (email.equals("")) {
            response.sendRedirect("lerFuncionario.jsp");
        } else {
            try {
                Funcionario f = FuncionarioDAO.getInstance().read(funcionario);
                request.setAttribute("funcionario", f);
                RequestDispatcher view = request.getRequestDispatcher("/lerFuncionario2.jsp");
                view.forward(request, response);
            } catch (SQLException ex) {
                response.sendRedirect("erro.jsp");
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (ServletException ex) {
                Logger.getLogger(LerFuncionarioAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

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
import model.Empresa;
import persistence.EmpresaDAO;

/**
 *
 * @author Nery
 */
public class GravarEmpresaAction implements Action{
    
    public GravarEmpresaAction(){}
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String nome = request.getParameter("textNome");
        String cnpj = request.getParameter("textCnpj");
        if(nome.equals("") || cnpj.equals("")) {
            response.sendRedirect("gravarEmpresa.jsp");
        } else{
            Empresa empresa = new Empresa(cnpj, nome);
            try{
                EmpresaDAO.getInstance().save(empresa);
                response.sendRedirect("Sucesso.jsp");
            }catch(SQLException ex){
                response.sendRedirect("Erro.jsp");
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }
}

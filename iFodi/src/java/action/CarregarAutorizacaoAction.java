/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.AutorizacaoAdquirirBrinde;
import model.AutorizacaoCancelarBrinde;
import model.AutorizacaoTrocarBrinde;
import model.Autorizacoes;
import model.FuncaoCliente;
import model.FuncaoFuncionario;
import model.FuncaoVendedor;

/**
 *
 * @author Jessica
 */
public class CarregarAutorizacaoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        FuncaoCliente cliente = new FuncaoCliente(null);
        FuncaoFuncionario funcionario = new FuncaoFuncionario(null);
        FuncaoVendedor vendedor = new FuncaoVendedor(null);

        cliente.assinaAutorizacao(new Autorizacoes(AutorizacaoAdquirirBrinde.getAutorizacaoAdquirirBrinde()));
        cliente.assinaAutorizacao(new Autorizacoes(AutorizacaoTrocarBrinde.getAutorizacaoTrocarBrinde()));
        cliente.assinaAutorizacao(new Autorizacoes(AutorizacaoCancelarBrinde.getAutorizacaoCancelarBrinde()));
    }
}

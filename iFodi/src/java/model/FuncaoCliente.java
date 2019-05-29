/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Jessica
 */
public class FuncaoCliente extends Funcao {

    public FuncaoCliente(FuncaoCliente funcao) {
        listaDeAutorizacao.add(AutorizacaoAdquirirBrinde.getAutorizacaoAdquirirBrinde());
        setFuncao(funcao);
    }

    @Override
    public String getDescricaoFuncao() {
        return "Cliente";
    }

}

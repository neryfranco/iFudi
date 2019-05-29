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
public class FuncaoFuncionario extends Funcao {

    public FuncaoFuncionario(FuncaoFuncionario funcao) {
        listaDeAutorizacao.add(AutorizacaoTrocarBrinde.getAutorizacaoTrocarBrinde());
        setFuncao(funcao);
    }
    
    @Override
    public String getDescricaoFuncao() {
        return "Funcionario";
    }

}

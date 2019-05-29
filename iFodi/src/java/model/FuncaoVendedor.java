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
public class FuncaoVendedor extends Funcao {

    public FuncaoVendedor(FuncaoVendedor funcao) {
        listaDeAutorizacao.add(AutorizacaoCancelarBrinde.getAutorizacaoCancelarBrinde());
        setFuncao(funcao);
    }

    @Override
    public String getDescricaoFuncao() {
        return "Vendedor";
    }
}

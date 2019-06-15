/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Jessica
 */
public abstract class Funcao {

    protected ArrayList listaDeAutorizacao = new ArrayList();
    private Funcao funcao;

    public Funcao getFuncao() {
        return funcao;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }

    public abstract String getDescricaoFuncao();

    public String assinaAutorizacao(Autorizacoes autorizacao) {
        if (listaDeAutorizacao.contains(autorizacao.getTipoAutorizacao())) {
            return getDescricaoFuncao();
        } else {
            if (funcao != null) {
                return funcao.assinaAutorizacao(autorizacao);
            } else {
                return "Sem autorizacao";
            }
        }
    }
}

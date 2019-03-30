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
public class PagCartao extends Pagamento{
    
    private String codCartao;

    public PagCartao(String codCartao, String codPagamento, String valor, String formaPagamento) {
        super(codPagamento, valor, formaPagamento);
        this.codCartao = codCartao;
    }

    public String getCodCartao() {
        return codCartao;
    }

    public void setCodCartao(String codCartao) {
        this.codCartao = codCartao;
    }
    
}

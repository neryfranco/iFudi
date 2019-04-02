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
public class PagDinheiro extends Pagamento {

    private String codDinheiro;

    public PagDinheiro(String codDinheiro, String codPagamento, String valor, String formaPagamento) {
        super(codPagamento, valor, formaPagamento);
        this.codDinheiro = codDinheiro;
    }

    public String getCodDinheiro() {
        return codDinheiro;
    }

    public void setCodDinheiro(String codDinheiro) {
        this.codDinheiro = codDinheiro;
    }

}

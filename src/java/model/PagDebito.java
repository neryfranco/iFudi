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
public class PagDebito extends Pagamento {

    private String codDebito;

    public PagDebito(String codDebito, String codPagamento, String valor, String formaPagamento) {
        super(codPagamento, valor, formaPagamento);
        this.codDebito = codDebito;
    }

    public String getCodDebito() {
        return codDebito;
    }

    public void setCodDebito(String codDebito) {
        this.codDebito = codDebito;
    }

}

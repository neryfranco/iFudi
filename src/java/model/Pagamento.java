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
public class Pagamento {

    private String codPagamento;
    private Pedido pedido;
    private Double valor;
    private FormaPagamento formaPagamento;

    public Pagamento(String codPagamento, Pedido pedido, Double valor, FormaPagamento formaPagamento) {
        this.codPagamento = codPagamento;
        this.pedido = pedido;
        this.valor = valor;
        this.formaPagamento = formaPagamento;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getCodPagamento() {
        return codPagamento;
    }

    public void setCodPagamento(String codPagamento) {
        this.codPagamento = codPagamento;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

}

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

    private Integer id;
    private Pedido pedido;
    private Double valor;
    private FormaPagamento formaPagamento;

    public Pagamento(Integer id, Pedido pedido, Double valor, FormaPagamento formaPagamento) {
        this.id = id;
        this.pedido = pedido;
        this.valor = valor;
        this.formaPagamento = formaPagamento;
    }

    public Pagamento(Integer id, Double valor) {
        this.id = id;
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Integer getID() {
        return id;
    }

    public void setID(Integer id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}

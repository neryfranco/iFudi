/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class ItemBuilder {

    private Integer id;
    private ProdutoBuilder produtoBuilder;
    private Integer quantidade;
    private Double precoTotal;
    private PedidoBuilder pedidoBuilder;

    public ItemBuilder() {
    }

    public ItemBuilder setId(Integer id) {
        this.id = id;
        return this;
    }

    public ItemBuilder setProduto(ProdutoBuilder produtoBuilder) {
        this.produtoBuilder = produtoBuilder;
        return this;
    }

    public ItemBuilder setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
        return this;
    }

    public ItemBuilder setPrecoTotal(Double precoTotal) {
        this.precoTotal = precoTotal;
        return this;
    }

    public ItemBuilder setPedido(PedidoBuilder pedidoBuilder) {
        this.pedidoBuilder = pedidoBuilder;
        return this;
    }

}

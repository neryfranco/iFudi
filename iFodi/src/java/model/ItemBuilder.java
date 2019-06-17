/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


public class ItemBuilder {

    private Integer id;
    private Produto produto;
    private Integer quantidade;
    private Double precoTotal;
    private Pedido pedido;

    public ItemBuilder() {
    }

    public ItemBuilder setId(Integer id) {
        this.id = id;
        return this;
    }

    public ItemBuilder setProduto(Produto produto) {
        this.produto = produto;
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

    public ItemBuilder setPedido(Pedido pedido) {
        this.pedido = pedido;
        return this;
    }

    public Item createItem() {
        return new Item(id, produto, quantidade, precoTotal, pedido);
    }
    
}

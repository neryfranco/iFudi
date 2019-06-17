/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;


public class PedidoBuilder {

    private Integer id;
    private List<Item> itens;
    private PedidoStatus status;
    private String data;
    private Integer tempoEstimado;
    private Avaliacao avaliacao;
    private Double frete;
    private Cliente cliente;
    private Restaurante restaurante;

    public PedidoBuilder() {
    }

    public PedidoBuilder setId(Integer id) {
        this.id = id;
        return this;
    }

    public PedidoBuilder setItens(List<Item> itens) {
        this.itens = itens;
        return this;
    }

    public PedidoBuilder setStatus(PedidoStatus status) {
        this.status = status;
        return this;
    }

    public PedidoBuilder setData(String data) {
        this.data = data;
        return this;
    }

    public PedidoBuilder setTempoEstimado(Integer tempoEstimado) {
        this.tempoEstimado = tempoEstimado;
        return this;
    }

    public PedidoBuilder setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
        return this;
    }

    public PedidoBuilder setFrete(Double frete) {
        this.frete = frete;
        return this;
    }

    public PedidoBuilder setCliente(Cliente cliente) {
        this.cliente = cliente;
        return this;
    }

    public PedidoBuilder setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
        return this;
    }

    public Pedido createPedido() {
        return new Pedido(id, itens, status, data, tempoEstimado, avaliacao, frete, cliente, restaurante);
    }
    
}

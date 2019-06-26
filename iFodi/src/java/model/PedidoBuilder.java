/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;


public class PedidoBuilder {

    private Integer id;
    private List<ItemBuilder> itemBuilder;
    private PedidoStatus status;
    private String data;
    private Integer tempoEstimado;
    private AvaliacaoBuilder avaliacaoBuilder;
    private Double frete;
    private Cliente cliente;
    private RestauranteBuilder restauranteBuilder;

    public PedidoBuilder setId(Integer id) {
        this.id = id;
        return this;
    }

    public PedidoBuilder setItens(List<ItemBuilder> itemBuilder) {
        this.itemBuilder = itemBuilder;
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

    public PedidoBuilder setAvaliacao(AvaliacaoBuilder avaliacaoBuilder) {
        this.avaliacaoBuilder = avaliacaoBuilder;
        return this;
    }

    public PedidoBuilder setFrete(Double frete) {
        this.frete = frete;
        return this;
    }

    public PedidoBuilder setCliente(Cliente cliente) {
        this.cliente =  cliente;
        return this;
    }

    public PedidoBuilder setRestaurante(RestauranteBuilder restauranteBuilder) {
        this.restauranteBuilder = restauranteBuilder;
        return this;
    }

    Object getStatus() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

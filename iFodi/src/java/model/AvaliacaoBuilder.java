/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


public class AvaliacaoBuilder {

    private Integer id;
    private String descricao;
    private Integer votacao;
    private Pedido pedido;

    public AvaliacaoBuilder() {
    }

    public AvaliacaoBuilder setId(Integer id) {
        this.id = id;
        return this;
    }

    public AvaliacaoBuilder setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public AvaliacaoBuilder setVotacao(Integer votacao) {
        this.votacao = votacao;
        return this;
    }

    public AvaliacaoBuilder setPedido(Pedido pedido) {
        this.pedido = pedido;
        return this;
    }

    public Avaliacao createAvaliacao() {
        return new Avaliacao(id, descricao, votacao, pedido);
    }
    
}

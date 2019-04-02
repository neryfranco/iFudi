/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author Jessica
 */
public class Pedido {

    private String codPedido;
    private List<Item> itens;
    private PedidoStatus status;
    private String data;
    private Integer tempoPreparacao; // em minutos
    private Avaliacao avaliacao;

    public Pedido(String codPedido) {
        this.codPedido = codPedido;
    }
  
    public String getCodPedido() {
        return codPedido;
    }

    public void setCodPedido(String codPedido) {
        this.codPedido = codPedido;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }
    
    public void addItem(Item item){
        itens.add(item);
    }
    
    public void removeItem(Item item){
        itens.remove(item);
    }
    
    public PedidoStatus getStatus() {
        return status;
    }

    public void setStatus(PedidoStatus status) {
        this.status = status;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Integer getTempoPreparacao() {
        return tempoPreparacao;
    }

    public void setTempoPreparacao(Integer tempoPreparacao) {
        this.tempoPreparacao = tempoPreparacao;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }
    
    
}

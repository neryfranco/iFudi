/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import java.util.Observable;

/**
 *
 * @author Jessica
 */
public class Pedido extends Observable{

    private Integer id;
    private List<Item> itens;
    private PedidoStatus status;
    private String data;
    private Integer tempoPreparacao; // em minutos
    private Avaliacao avaliacao;
    private Frete frete;
    private Cliente cliente;
    private Restaurante restaurante;

    public Pedido(Integer id) {
        this.id = id;
    }

    public Pedido(Integer id, List<Item> itens, PedidoStatus status, String data, Integer tempoPreparacao, Avaliacao avaliacao, Frete frete, Cliente cliente, Restaurante restaurante) {
        this.id = id;
        this.itens = itens;
        this.status = status;
        this.data = data;
        this.tempoPreparacao = tempoPreparacao;
        this.avaliacao = avaliacao;
        this.frete = frete;
        this.cliente = cliente;
        this.restaurante = restaurante;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        setChanged();
        notifyObservers();
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

    public Frete getFrete() {
        return frete;
    }

    public void setFrete(Frete frete) {
        this.frete = frete;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }
    
    
}

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
    private Integer tempoEstimado; // em minutos
    private Avaliacao avaliacao;
    private Double frete;
    private Cliente cliente;
    private Restaurante restaurante;

    public Pedido(Integer id) {
        this.id = id;
        this.status = new PedidoSolicitado();
    }

    public Pedido(Integer id, List<Item> itens, PedidoStatus status, String data, Integer tempoEstimado, Avaliacao avaliacao, Double frete, Cliente cliente, Restaurante restaurante) {
        this.id = id;
        this.itens = itens;
        this.status = new PedidoSolicitado();
        this.data = data;
        this.tempoEstimado = tempoEstimado;
        this.avaliacao = avaliacao;
        this.frete = frete;
        this.cliente = cliente;
        this.restaurante = restaurante;
    }

    public Pedido(Integer id, String data, Integer tempoEstimado) {
        this.id = id;
        this.data = data;
        this.tempoEstimado = tempoEstimado;
        this.status = new PedidoSolicitado();
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

    public void addItem(Item item) {
        itens.add(item);
    }

    public void removeItem(Item item) {
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
    
    public String getStatusNome(){
        return status.getNomeClasse();
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Integer getTempoEstimado() {
        return tempoEstimado;
    }

    public void setTempoEstimado(Integer tempoEstimado) {
        this.tempoEstimado = tempoEstimado;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Double getFrete() {
        return frete;
    }

    public void setFrete(Double frete) {
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

    public String solicitarPedido(){
        return status.solicitar(this);
    }
    
    public String prepararPedido(){
        return status.preparar(this);
    }
    
    public String entregarPedido(){
        return status.entregar(this);
    }
    
    public String finalizarPedido(){
        return status.finalizar(this);
    }
    
    public String cancelarPedido(){
        return status.cancelar(this);
    }
}

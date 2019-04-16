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
public class Produto {

    private Integer id;
    private String descricao;
    private Promocao promocao;
    private Double preco;
    private Restaurante restaurante;

    public Produto(Integer id, String descricao, Restaurante restaurante, Double preco) {
        this.id = id;
        this.descricao = descricao;
        this.restaurante = restaurante;
        this.preco = preco;
    }
    
    public Produto(Integer id, String descricao, Restaurante restaurante) {
        this.id = id;
        this.descricao = descricao;
        this.restaurante = restaurante;
    }

    public Produto(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Promocao getPromocao() {
        return promocao;
    }

    public void setPromocao(Promocao promocao) {
        this.promocao = promocao;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurate) {
        this.restaurante = restaurate;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
    
}

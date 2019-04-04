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

    private String codProduto;
    private String descricao;
    private Promocao promocao;
    private Restaurante restaurate;

    public Produto(String codProduto, String descricao, Restaurante restaurate) {
        this.codProduto = codProduto;
        this.descricao = descricao;
        this.restaurate = restaurate;
    }

    public String getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(String codProduto) {
        this.codProduto = codProduto;
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

    public Restaurante getRestaurate() {
        return restaurate;
    }

    public void setRestaurate(Restaurante restaurate) {
        this.restaurate = restaurate;
    }

    
}

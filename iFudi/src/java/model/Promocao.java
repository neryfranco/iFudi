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
public class Promocao {

    private String codPromocao;
    private String descricao;
    private Double porcentagem;
    private Double valorFinal;
    private Produto produto;

    public Promocao(String codPromocao, String descricao, Double porcentagem, Produto produto) {
        this.codPromocao = codPromocao;
        this.descricao = descricao;
        this.porcentagem = porcentagem;
        this.produto = produto;
    }

    public String getCodPromocao() {
        return codPromocao;
    }

    public void setCodPromocao(String codPromocao) {
        this.codPromocao = codPromocao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(Double porcentagem) {
        this.porcentagem = porcentagem;
    }

    public Double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(Double valorFinal) {
        this.valorFinal = valorFinal;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    
}

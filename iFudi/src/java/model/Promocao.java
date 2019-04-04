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

    public Promocao(String codPromocao, String descricao, Double porcentagem) {
        this.codPromocao = codPromocao;
        this.descricao = descricao;
        this.porcentagem = porcentagem;
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
   
}

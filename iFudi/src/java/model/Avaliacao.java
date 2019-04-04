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
public class Avaliacao {

    private String id;
    private String descricao;
    private Integer votacao;

    public Avaliacao(String id, String descricao, Integer votacao) {
        this.id = id;
        this.descricao = descricao;
        this.votacao = votacao;
    }

    public String getCodAvaliacao() {
        return id;
    }

    public void setCodAvaliacao(String id) {
        this.id = id;
    }

    public String getDescAvaliacao() {
        return descricao;
    }

    public void setDescAvaliacao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getVotacao() {
        return votacao;
    }

    public void setVotacao(Integer votacao) {
        this.votacao = votacao;
    }

    
}

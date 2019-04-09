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

    private Integer id;
    private String descricao;
    private Integer votacao;

    public Avaliacao(Integer id, String descricao, Integer votacao) {
        this.id = id;
        this.descricao = descricao;
        this.votacao = votacao;
    }

    public Integer getID() {
        return id;
    }

    public void setID(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getVotacao() {
        return votacao;
    }

    public void setVotacao(Integer votacao) {
        this.votacao = votacao;
    }

    
}

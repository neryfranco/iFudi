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

    private String codAvaliacao;
    private String descAvaliacao;

    public Avaliacao(String codAvaliacao, String descAvaliacao) {
        this.codAvaliacao = codAvaliacao;
        this.descAvaliacao = descAvaliacao;
    }

    public String getDescAvaliacao() {
        return descAvaliacao;
    }

    public void setDescAvaliacao(String descAvaliacao) {
        this.descAvaliacao = descAvaliacao;
    }

    public String getCodAvaliacao() {
        return codAvaliacao;
    }

    public void setCodAvaliacao(String codAvaliacao) {
        this.codAvaliacao = codAvaliacao;
    }

}

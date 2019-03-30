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
public class Itens {

    private String codItens;
    private String descItens;

    public Itens(String codItens, String descItens) {
        this.codItens = codItens;
        this.descItens = descItens;
    }

    public String getCodItens() {
        return codItens;
    }

    public void setCodItens(String codItens) {
        this.codItens = codItens;
    }

    public String getDescItens() {
        return descItens;
    }

    public void setDescItens(String descItens) {
        this.descItens = descItens;
    }

}

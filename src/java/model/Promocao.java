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
    private String cupom;
    private String tipoPromocao;

    public Promocao(String codPromocao, String cupom, String tipoPromocao) {
        this.codPromocao = codPromocao;
        this.cupom = cupom;
        this.tipoPromocao = tipoPromocao;
    }

    public String getTipoPromocao() {
        return tipoPromocao;
    }

    public void setTipoPromocao(String tipoPromocao) {
        this.tipoPromocao = tipoPromocao;
    }

    public String getCodPromocao() {
        return codPromocao;
    }

    public void setCodPromocao(String codPromocao) {
        this.codPromocao = codPromocao;
    }

    public String getCupom() {
        return cupom;
    }

    public void setCupom(String cupom) {
        this.cupom = cupom;
    }

}

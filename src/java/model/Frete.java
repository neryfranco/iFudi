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
public class Frete {

    private String codFrete;
    private String taxaFrete;
    private String tempoEntrega;

    public Frete(String codFrete, String taxaFrete, String tempoEntrega) {
        this.codFrete = codFrete;
        this.taxaFrete = taxaFrete;
        this.tempoEntrega = tempoEntrega;
    }

    public String getCodFrete() {
        return codFrete;
    }

    public void setCodFrete(String codFrete) {
        this.codFrete = codFrete;
    }

    public String getTaxaFrete() {
        return taxaFrete;
    }

    public void setTaxaFrete(String taxaFrete) {
        this.taxaFrete = taxaFrete;
    }

    public String getTempoEntrega() {
        return tempoEntrega;
    }

    public void setTempoEntrega(String tempoEntrega) {
        this.tempoEntrega = tempoEntrega;
    }

}

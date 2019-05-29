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
public class Autorizacoes {

    private TipoAutorizacao tipoAutorizacao;

    public Autorizacoes(TipoAutorizacao tipoAutorizacao) {
        this.tipoAutorizacao = tipoAutorizacao;
    }

    public TipoAutorizacao getTipoAutorizacao() {
        return tipoAutorizacao;
    }

    public void setTipoDocumento(TipoAutorizacao tipoAutorizacao) {
        this.tipoAutorizacao = tipoAutorizacao;
    }
}

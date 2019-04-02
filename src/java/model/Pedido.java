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
public class Pedido {

    private String codPedido;
    private String descPedido;
    private String status;

    public Pedido(String codPedido, String descPedido, String status) {
        this.codPedido = codPedido;
        this.descPedido = descPedido;
        this.status = status;
    }

    public String getCodPedido() {
        return codPedido;
    }

    public void setCodPedido(String codPedido) {
        this.codPedido = codPedido;
    }

    public String getDescPedido() {
        return descPedido;
    }

    public void setDescPedido(String descPedido) {
        this.descPedido = descPedido;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}

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
public class PedidoMemento {

    private PedidoStatus status;

    public PedidoMemento(PedidoStatus estadoSalvar) {
        status = estadoSalvar;
    }

    public PedidoStatus getEstadoSalvo() {
        return status;
    }

    public String toString() {
        return status.getNomeClasse();
    }
}

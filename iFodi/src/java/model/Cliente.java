/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Jessica
 */
public class Cliente extends UsuarioBuilder implements Observer {

    @Override
    public void update(Observable pedidoSubject, Object arg) {
        String statusPedido;
        if (pedidoSubject instanceof PedidoBuilder) {
            PedidoBuilder pedidoBuilder;
            pedidoBuilder = (PedidoBuilder) pedidoSubject;
            statusPedido = pedidoBuilder.getStatus().getNomeClasse();
            System.out.println("Atenção" + getNome() + "seu pedido está no estado de: " + statusPedido);
        }
    }

    private String getNome() {
        return null;
    }
}

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
public class Cliente extends Usuario implements Observer {

    public Cliente(String email, String senha, String nome) {
        super(email, senha, nome);
    }

    @Override
    public void update(Observable pedidoSubject, Object arg) {
        String statusPedido;
        if (pedidoSubject instanceof Pedido) {
            Pedido pedido = (Pedido) pedidoSubject;
            statusPedido = pedido.getStatus().getNomeClasse();
            System.out.println("Atenção" + getNome() + "seu pedido está no estado de: " + statusPedido);
        }
    }
}

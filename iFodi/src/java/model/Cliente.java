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

    private Cartao cartao;    
    
    public Cliente(String email, String senha, String nome, Observable pedido) {
        super(email, senha, nome);
        pedido.addObserver(this);
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }

    @Override
    public void update(Observable pedidoSubject, Object arg) {
        PedidoStatus statusPedido;
        if (pedidoSubject instanceof Pedido) {
            Pedido pedido = (Pedido) pedidoSubject;
            statusPedido = pedido.getStatus();
            System.out.println("Atenção" + getNome() + "seu pedido está no estado de: " + statusPedido);

        }

    }

    @Override
    public boolean getTipoUsuario() {
        return true;
    }

}

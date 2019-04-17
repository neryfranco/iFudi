/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Nery
 */
public class PedidoEntregando implements PedidoStatus{

    @Override
    public String cancelando(Pedido pedido) {
        return "Não pode estar entregando";
    }


    @Override
    public String entregando(Pedido pedido) {
        return "Não pode estar entregando";
    }

    @Override
    public String entregue(Pedido pedido) {
        pedido.setStatus(new PedidoEntregando());
        return "Pedido entregue";
    }

    @Override
    public String preparando(Pedido pedido) {
        return "Não pode estar entregando";
    }

    @Override
    public String solicitado(Pedido pedido) {
        return "Não pode estar entregando";
    }
  
}

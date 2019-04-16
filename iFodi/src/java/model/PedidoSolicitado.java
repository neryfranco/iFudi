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
public class PedidoSolicitado implements PedidoStatus{

    @Override
    public String cancelando(Pedido pedido) {
        return "Não pode solicitado";
    }

    @Override
    public String entregando(Pedido pedido) {
        pedido.setStatus(new PedidoSolicitado());
        return "Pedido solicitado";
    }

    @Override
    public String entregue(Pedido pedido) {
        pedido.setStatus(new PedidoSolicitado());
        return "Pedido solicitado";
    }

    @Override
    public String preparando(Pedido pedido) {
        pedido.setStatus(new PedidoSolicitado());
        return "Pedido solicitado";
    }

    @Override
    public String solicitado(Pedido pedido) {
        return "Não pode solicitado";
    }

     
}

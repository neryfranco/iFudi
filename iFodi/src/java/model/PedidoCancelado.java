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
public class PedidoCancelado implements PedidoStatus{

    @Override
    public String cancelando(Pedido pedido) {
        return "Não pode cancelar";
    }

    @Override
    public String entregando(Pedido pedido) {
        return "Não pode cancelar";
    }

    @Override
    public String entregue(Pedido pedido) {
        return "Não pode cancelar";
    }

    @Override
    public String preparando(Pedido pedido) {
        return "Não pode cancelar";
    }

    @Override
    public String solicitado(Pedido pedido) {
        pedido.setStatus(new PedidoCancelado());
        return "Pedido Cancelado";
    }

  
     
}

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
    
    public String nomeClasse = "PedidoCancelado";

    @Override
    public String cancelar(Pedido pedido) {
        return "Pedido cancelado não pode cancelar";
    }

    @Override
    public String entregar(Pedido pedido) {
        return "Pedido cancelado não pode entregar";
    }

    @Override
    public String finalizar(Pedido pedido) {
        return "Pedido cancelado não pode finalizar";
    }

    @Override
    public String preparar(Pedido pedido) {
        return "Pedido cancelado não pode preparar";
    }

    @Override
    public String solicitar(Pedido pedido) {
        pedido.setStatus(new PedidoSolicitado());
        return "Pedido Solicitado";
    }

    public String getNomeClasse(){
        return "PedidoCancelado";
    }
    
}

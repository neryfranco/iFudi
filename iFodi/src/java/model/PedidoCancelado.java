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
public class PedidoCancelado implements PedidoStatus {

    public String nomeClasse = "PedidoCancelado";

    @Override
    public String cancelar(PedidoBuilder pedidoBuilder) {
        return "Pedido cancelado não pode cancelar";
    }

    @Override
    public String entregar(PedidoBuilder pedidoBuilder) {
        return "Pedido cancelado não pode entregar";
    }

    @Override
    public String finalizar(PedidoBuilder pedidoBuilder) {
        return "Pedido cancelado não pode finalizar";
    }

    @Override
    public String preparar(PedidoBuilder pedidoBuilder) {
        return "Pedido cancelado não pode preparar";
    }

    @Override
    public String solicitar(PedidoBuilder pedidoBuilder) {
        pedidoBuilder.setStatus(new PedidoSolicitado());
        return "Pedido Solicitado";
    }

    public String getNomeClasse() {
        return "PedidoCancelado";
    }
}

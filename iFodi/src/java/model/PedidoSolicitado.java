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
public class PedidoSolicitado implements PedidoStatus {

    public String nomeClasse = "PedidoSolicitado";

    @Override
    public String cancelar(PedidoBuilder pedidoBuilder) {
        pedidoBuilder.setStatus(new PedidoCancelado());
        return "Pedido cancelado";
    }

    @Override
    public String entregar(PedidoBuilder pedidoBuilder) {
        return "Pedido solicitado não pode ser entregue";
    }

    @Override
    public String finalizar(PedidoBuilder pedidoBuilder) {
        return "Pedido solicitado não pode ser finalizado";
    }

    @Override
    public String preparar(PedidoBuilder pedidoBuilder) {
        pedidoBuilder.setStatus(new PedidoPreparando());
        return "Pedido em preparação";
    }

    @Override
    public String solicitar(PedidoBuilder pedidoBuilder) {
        return "Pedido solicitado não pode ser solicitado novamente";
    }

    public String getNomeClasse() {
        return "PedidoSolicitado";
    }
}

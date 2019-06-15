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
    public String cancelar(Pedido pedido) {
        pedido.setStatus(new PedidoCancelado());
        return "Pedido cancelado";
    }

    @Override
    public String entregar(Pedido pedido) {
        return "Pedido solicitado não pode ser entregue";
    }

    @Override
    public String finalizar(Pedido pedido) {
        return "Pedido solicitado não pode ser finalizado";
    }

    @Override
    public String preparar(Pedido pedido) {
        pedido.setStatus(new PedidoPreparando());
        return "Pedido em preparação";
    }

    @Override
    public String solicitar(Pedido pedido) {
        return "Pedido solicitado não pode ser solicitado novamente";
    }

    public String getNomeClasse() {
        return "PedidoSolicitado";
    }
}

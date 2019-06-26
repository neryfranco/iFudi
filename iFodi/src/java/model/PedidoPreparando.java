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
public class PedidoPreparando implements PedidoStatus {

    public String nomeClasse = "PedidoPreparando";

    @Override
    public String cancelar(PedidoBuilder pedidoBuilder) {
        return "Pedido em preparação não pode ser cancelado";
    }

    @Override
    public String entregar(PedidoBuilder pedidoBuilder) {
        pedidoBuilder.setStatus(new PedidoEntregando());
        return "Pedido saiu para entrega";
    }

    @Override
    public String finalizar(PedidoBuilder pedidoBuilder) {
        return "Pedido em preparação não pode ser finalizado";
    }

    @Override
    public String preparar(PedidoBuilder pedidoBuilder) {
        return "Pedido em preparação não pode ser preparado novamente";
    }

    @Override
    public String solicitar(PedidoBuilder pedidoBuilder) {
        return "Pedido em preparação não pode ser solicitado";
    }

    public String getNomeClasse() {
        return "PedidoPreparando";
    }
}

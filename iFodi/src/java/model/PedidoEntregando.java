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
public class PedidoEntregando implements PedidoStatus {

    public String nomeClasse = "PedidoEntregando";

    @Override
    public String cancelar(Pedido pedido) {
        return "Pedido entregue não pode ser cancelado";
    }

    @Override
    public String entregar(Pedido pedido) {
        return "Pedido entregue não pode sair para entrega novamente";
    }

    @Override
    public String finalizar(Pedido pedido) {
        pedido.setStatus(new PedidoFinalizado());
        return "Pedido finalizado";
    }

    @Override
    public String preparar(Pedido pedido) {
        return "Pedido entregue não pode ser preparado";
    }

    @Override
    public String solicitar(Pedido pedido) {
        return "Pedido entregue não pode ser solicitado novamente";
    }

    public String getNomeClasse() {
        return "PedidoEntregando";
    }
}

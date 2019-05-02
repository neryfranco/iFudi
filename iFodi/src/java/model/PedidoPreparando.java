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
public class PedidoPreparando implements PedidoStatus{

    public String nomeClasse = "PedidoPreparando";
    
    @Override
    public String cancelar(Pedido pedido) {
        return "Pedido em preparação não pode ser cancelado";
    }

    @Override
    public String entregar(Pedido pedido) {
        pedido.setStatus(new PedidoEntregando());
        return "Pedido saiu para entrega";
    }

    @Override
    public String finalizar(Pedido pedido) {
        return "Pedido em preparação não pode ser finalizado";
    }

    @Override
    public String preparar(Pedido pedido) {
        return "Pedido em preparação não pode ser preparado novamente";
    }

    @Override
    public String solicitar(Pedido pedido) {
        return "Pedido em preparação não pode ser solicitado";
    }

    public String getNomeClasse(){
        return "PedidoPreparando";
    }
}

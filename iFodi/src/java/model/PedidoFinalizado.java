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
public class PedidoFinalizado implements PedidoStatus{

    public String nomeClasse = "PedidoFinalizado";
    
    @Override
    public String cancelar(Pedido pedido) {
        return "Pedido finalizado não pode ser cancelado";
    }

    @Override
    public String entregar(Pedido pedido) {
        return "Pedido finalizado não pode ser entregue";
    }

    @Override
    public String finalizar(Pedido pedido) {
        return "Pedido finalizado não pode ser finalizado novamente";
    }

    @Override
    public String preparar(Pedido pedido) {
        return "Pedido finalizado não pode ser preparado";
    }

    @Override
    public String solicitar(Pedido pedido) {
       return "Pedido finalizado não pode ser solicitado";
    }

    public String getNomeClasse(){
        return "PedidoFinalizado";
    }
}

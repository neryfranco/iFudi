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
public interface PedidoStatus {    
    
    public String cancelando(Pedido pedido);
    public String entregando(Pedido pedido);
    public String entregue(Pedido pedido);
    public String preparando(Pedido pedido);
    public String solicitado(Pedido pedido);
}

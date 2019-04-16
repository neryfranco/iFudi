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

    public PedidoStatus cancelar(Pedido p);
    public PedidoStatus entregar(Pedido p);
    public PedidoStatus finalizar(Pedido p);
    public PedidoStatus preparar(Pedido p);
    public PedidoStatus solicitar(Pedido p);
}

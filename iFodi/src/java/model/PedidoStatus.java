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
public abstract class PedidoStatus extends Pedido {

    public PedidoStatus(Integer id) {
        super(id);
    }

    
    
    public PedidoStatus cancelando(){return getStatus();};
    public PedidoStatus entregando(){return getStatus();};
    public PedidoStatus entregue(){return getStatus();};
    public PedidoStatus preparando(){return getStatus();};
    public PedidoStatus solicitado(){return getStatus();};
}

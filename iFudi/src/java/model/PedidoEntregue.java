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
public class PedidoEntregue extends PedidoStatus{

    public PedidoEntregue(String status) {
        super(status);
    }
    
    public PedidoStatus cancelando(){System.out.println("Não");return getStatus();};
    public PedidoStatus entregando(){System.out.println("Não");return getStatus();};
    public PedidoStatus entregue(){System.out.println("Não");return getStatus();};
    public PedidoStatus preparando(){System.out.println("Não");return getStatus();};
    public PedidoStatus solicitado(){System.out.println("Não");return getStatus();};  
}

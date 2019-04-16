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
public class PedidoCancelado implements PedidoStatus{

    public PedidoStatus cancelar(Pedido p){
        System.out.println("Não");
        return this;
    public PedidoStatus entregar(){System.out.println("Não");return getStatus();};
    public PedidoStatus finalizar(){System.out.println("Não");return getStatus();};
    public PedidoStatus preparar(){System.out.println("Não");return getStatus();};
    public PedidoStatus solicitar(){System.out.println("Não");return getStatus();};    
}

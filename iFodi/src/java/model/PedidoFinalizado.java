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
public class PedidoFinalizado extends PedidoStatus{

    public PedidoFinalizado(Integer id) {
        super(id);
    }

    
    
    public PedidoStatus cancelar(){System.out.println("Não");return getStatus();};
    public PedidoStatus entregar(){System.out.println("Não");return getStatus();};
    public PedidoStatus finalizar(){System.out.println("Não");return getStatus();};
    public PedidoStatus preparar(){System.out.println("Não");return getStatus();};
    public PedidoStatus solicitar(){System.out.println("Não");return getStatus();};  
}

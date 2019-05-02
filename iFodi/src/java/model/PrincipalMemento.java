/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Jessica
 */
public class PrincipalMemento {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArrayList <PedidoMemento> estadoSalvos = new ArrayList();
        
        Pedido pedido = new Pedido(2);
        pedido.getId();
        pedido.setStatus(new PedidoCancelado());
        estadoSalvos.add(pedido.saveToMemento());
        pedido.setStatus(new PedidoEntregando());
        estadoSalvos.add(pedido.saveToMemento());
        pedido.setStatus(new PedidoFinalizado());
        
        for (Iterator i = estadoSalvos.iterator(); i.hasNext();)
            System.out.println(i.next());
        
        pedido.restoreFromMemento(estadoSalvos.get(1));
        System.out.println(pedido.getId());
    }
    
}

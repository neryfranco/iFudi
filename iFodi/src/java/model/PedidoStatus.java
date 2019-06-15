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

    public String cancelar(Pedido pedido);

    public String entregar(Pedido pedido);

    public String finalizar(Pedido pedido);

    public String preparar(Pedido pedido);

    public String solicitar(Pedido pedido);

    public String getNomeClasse();
}

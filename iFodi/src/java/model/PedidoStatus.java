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

    public String cancelar(PedidoBuilder pedidoBuilder);

    public String entregar(PedidoBuilder pedidoBuilder);

    public String finalizar(PedidoBuilder pedidoBuilder);

    public String preparar(PedidoBuilder pedidoBuilder);

    public String solicitar(PedidoBuilder pedidoBuilder);

    public String getNomeClasse();
}

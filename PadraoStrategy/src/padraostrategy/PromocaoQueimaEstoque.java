/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package padraostrategy;

/**
 *
 * @author Nery
 */
public class PromocaoQueimaEstoque implements Promocao{
    public int obterDesconto() { return 20; }
    public String obterPromocao() { return "Queima de Estoque"; }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Jessica
 */
public class PagDebito implements FormaPagamento {

    @Override
    public String obterDesconto() {
        return "Desconto de 10%";
    }

}

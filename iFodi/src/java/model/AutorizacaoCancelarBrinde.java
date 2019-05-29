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
public class AutorizacaoCancelarBrinde implements TipoAutorizacao {

    private static AutorizacaoCancelarBrinde autorizacaoCancelarBrinde = new AutorizacaoCancelarBrinde();

    public static AutorizacaoCancelarBrinde getAutorizacaoCancelarBrinde() {
        return autorizacaoCancelarBrinde;
    }
}

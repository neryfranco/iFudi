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
public class AutorizacaoTrocarBrinde implements TipoAutorizacao {

    private static AutorizacaoTrocarBrinde autorizacaoTrocarBrinde = new AutorizacaoTrocarBrinde();

    public static AutorizacaoTrocarBrinde getAutorizacaoTrocarBrinde() {
        return autorizacaoTrocarBrinde;
    }
}

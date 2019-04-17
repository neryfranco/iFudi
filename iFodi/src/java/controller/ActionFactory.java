/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.PedidoStatus;

/**
 *
 * @author Jessica
 */
public class ActionFactory {

    public static Action create(String action) {

        Action actionObject = null;
        String nomeClasse = action;
        Class classe = null;
        Object objeto = null;

        try {
            classe = Class.forName(nomeClasse);
            objeto = classe.newInstance();

        } catch (Exception ex) {
            return null;
        }
        if (!(objeto instanceof Action)) {
            return null;
        }
        actionObject = (Action) objeto;
        return actionObject;
    }
    
    public static PedidoStatus createPedidoStatus(String action) {

        PedidoStatus actionObject = null;
        String nomeClasse = action;
        Class classe = null;
        Object objeto = null;

        try {
            classe = Class.forName(nomeClasse);
            objeto = classe.newInstance();

        } catch (Exception ex) {
            return null;
        }
        if (!(objeto instanceof PedidoStatus)) {
            return null;
        }
        actionObject = (PedidoStatus) objeto;
        return actionObject;
    }

}

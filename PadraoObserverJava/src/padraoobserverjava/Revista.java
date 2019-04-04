/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package padraoobserverjava;

import java.util.Observable;
import sun.java2d.Disposer;

/**
 *
 * @author Nery
 */
public class Revista extends Observable{

    public int edicao;
    
    public void setEdicao(int novaEdicao){
        this.edicao = novaEdicao;
        setChanged();
        notifyObservers();
    }
    
    public int getEdicao(){
        return this.edicao;
    }
    
}

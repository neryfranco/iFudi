package model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Observable;
import sun.java2d.Disposer;

/**
 *
 * @author Nery
 */
public class Revista extends Observable{

    public String codigo;
    public int edicao;

    public Revista(String codigo, int edicao) {
        this.codigo = codigo;
        this.edicao = edicao;
    }
    

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }  
    
    public void setEdicao(int novaEdicao){
        this.edicao = novaEdicao;
        setChanged();
        notifyObservers();
    }
    
    public int getEdicao(){
        return this.edicao;
    }
    
}

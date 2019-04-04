/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package padraoobserverjava;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Nery
 */
public class Assinante implements Observer{

    public String nome;

    public Assinante(Observable revista) {
        revista.addObserver(this);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public void update(Observable revistaSubject, Object arg) {
        int edicaoNovaRevista;
        if(revistaSubject instanceof Revista){
            Revista revista = (Revista) revistaSubject;
            edicaoNovaRevista = revista.getEdicao();
            System.out.println("Atenção " + getNome() +
                    ", já chegou mais uma edição da Revista. " +
                    "Esta é a sua edição número " +
                    edicaoNovaRevista);
        }
    }
    
    
}

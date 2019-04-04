package model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Nery
 */
public class Assinante implements Observer{

    public String email;
    public String nome;

    public Assinante(String email, String nome, Observable revista) {
        this.email = email;
        this.nome = nome;
        revista.addObserver(this);
    }

    public Assinante(Observable revista) {
        revista.addObserver(this);
    }
    
    public Assinante(String email, String nome) {
        this.email = email;
        this.nome = nome;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

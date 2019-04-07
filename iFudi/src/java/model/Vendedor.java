/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author Jessica
 */
public class Vendedor extends Usuario {

    private List<Restaurante> restaurantes;

    public Vendedor(String email, String senha, String nome) {
        super(email, senha, nome);
    }
    
    public List<Restaurante> getRestaurantes() {
        return restaurantes;
    }

    public void setRestaurantes(List<Restaurante> restaurantes) {
        this.restaurantes = restaurantes;
    }
  
    public void addRestaurante(Restaurante restaurante){
        restaurantes.add(restaurante);
    }
    
    public void removeRestaurante(Restaurante restaurante){
        restaurantes.remove(restaurante);
    }
}

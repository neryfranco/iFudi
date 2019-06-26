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
public class Vendedor extends UsuarioBuilder{

    private List<RestauranteBuilder> restauranteBuilder;

    public List<RestauranteBuilder> getRestaurantes() {
        return restauranteBuilder;
    }

    public void setRestaurantes(List<RestauranteBuilder> restauranteBuilder) {
        this.restauranteBuilder = restauranteBuilder;
    }

    public void addRestauranteBuilder(RestauranteBuilder restauranteBuilder) {
        restauranteBuilder.add(restauranteBuilder);
    }

    public void removeRestaurante(RestauranteBuilder restaurante) {
        restauranteBuilder.remove(restauranteBuilder);
    }
}

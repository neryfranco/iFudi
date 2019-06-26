/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class ProdutoBuilder {

    private Integer id;
    private String descricao;
    private RestauranteBuilder restauranteBuider;
    private Double preco;

    public ProdutoBuilder() {
    }

    public ProdutoBuilder setId(Integer id) {
        this.id = id;
        return this;
    }

    public ProdutoBuilder setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public ProdutoBuilder setRestaurante(RestauranteBuilder restauranteBuider) {
        this.restauranteBuider = restauranteBuider;
        return this;
    }

    public ProdutoBuilder setPreco(Double preco) {
        this.preco = preco;
        return this;
    }

}

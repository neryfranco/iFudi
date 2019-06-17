/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;


public class RestauranteBuilder {

    private String cnpj;
    private String nome;
    private String rua;
    private String numero;
    private String cidade;
    private String estado;
    private List<Produto> listaProdutos;
    private Categoria categoria;
    private Vendedor vendedor;

    public RestauranteBuilder() {
    }

    public RestauranteBuilder setCnpj(String cnpj) {
        this.cnpj = cnpj;
        return this;
    }

    public RestauranteBuilder setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public RestauranteBuilder setRua(String rua) {
        this.rua = rua;
        return this;
    }

    public RestauranteBuilder setNumero(String numero) {
        this.numero = numero;
        return this;
    }

    public RestauranteBuilder setCidade(String cidade) {
        this.cidade = cidade;
        return this;
    }

    public RestauranteBuilder setEstado(String estado) {
        this.estado = estado;
        return this;
    }

    public RestauranteBuilder setListaProdutos(List<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
        return this;
    }

    public RestauranteBuilder setCategoria(Categoria categoria) {
        this.categoria = categoria;
        return this;
    }

    public RestauranteBuilder setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
        return this;
    }

    public Restaurante createRestaurante() {
        return new Restaurante(cnpj, nome, rua, numero, cidade, estado, listaProdutos, categoria, vendedor);
    }
    
}

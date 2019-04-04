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
public class Restaurante {

    private String cnpj;
    private String nome;
    private List<Produto> listaProdutos;
    private Categoria categoria;

    public Restaurante(String cnpj, String nome, Categoria categoria) {
        this.cnpj = cnpj;
        this.nome = nome;
        this.categoria = categoria;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(List<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }
    
    public void addProduto(Produto produto){
        listaProdutos.add(produto);
    }
    
    public void removeProduto(Produto produto){
        listaProdutos.remove(produto);
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    
}

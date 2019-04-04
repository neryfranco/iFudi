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
    private String rua;
    private String numero;
    private String cidade;
    private String estado;
    private List<Produto> listaProdutos;
    private Categoria categoria;
    private Vendedor vendedor;

    public Restaurante(String cnpj, String nome, String rua, String numero, String cidade, String estado, List<Produto> listaProdutos, Categoria categoria, Vendedor vendedor) {
        this.cnpj = cnpj;
        this.nome = nome;
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
        this.listaProdutos = listaProdutos;
        this.categoria = categoria;
        this.vendedor = vendedor;
    }

    public Restaurante(String cnpj) {
        this.cnpj = cnpj;
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

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(List<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    public void addProduto(Produto produto){
        listaProdutos.add(produto);
    }
    
    public void removeProduto(Produto produto){
        listaProdutos.remove(produto);
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
    
}

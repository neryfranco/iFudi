/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Jessica
 */
public class Restaurante {

    private String codRestaurante;
    private String nome;
    private String ramoAtividade;

    public Restaurante(String codRestaurante, String nome, String ramoAtividade) {
        this.codRestaurante = codRestaurante;
        this.nome = nome;
        this.ramoAtividade = ramoAtividade;
    }

    public String getRamoAtividade() {
        return ramoAtividade;
    }

    public void setRamoAtividade(String ramoAtividade) {
        this.ramoAtividade = ramoAtividade;
    }

    public String getCodRestaurante() {
        return codRestaurante;
    }

    public void setCodRestaurante(String codRestaurante) {
        this.codRestaurante = codRestaurante;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}

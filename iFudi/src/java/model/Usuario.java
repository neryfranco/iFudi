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
public class Usuario {

    private String email;
    private String senha;
    private String nome;
    private String cpf;
    private String rua;
    private String numero;
    private String cidade;
    private String estado;

    public Usuario(String email, String senha, String nome) {
        this.email = email;
        this.senha = senha;
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

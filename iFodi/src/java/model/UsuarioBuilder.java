/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


public class UsuarioBuilder {

    private String email;
    private String senha;
    private String nome;
    private String cpf;
    private String rua;
    private String numero;
    private String cidade;
    private String estado;

    public UsuarioBuilder() {
    }

    public UsuarioBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public UsuarioBuilder setSenha(String senha) {
        this.senha = senha;
        return this;
    }

    public UsuarioBuilder setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public UsuarioBuilder setCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public UsuarioBuilder setRua(String rua) {
        this.rua = rua;
        return this;
    }

    public UsuarioBuilder setNumero(String numero) {
        this.numero = numero;
        return this;
    }

    public UsuarioBuilder setCidade(String cidade) {
        this.cidade = cidade;
        return this;
    }

    public UsuarioBuilder setEstado(String estado) {
        this.estado = estado;
        return this;
    }

    public Usuario createUsuario() {
        return new Usuario(email, senha, nome, cpf, rua, numero, cidade, estado);
    }
    
}

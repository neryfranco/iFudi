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
public class Cliente extends Usuario {

    private String codCliente;
    private String nome;
    private String cpf;

    public Cliente(String codCliente, String nome, String cpf, String codUsuario, String email, String senha) {
        super(codUsuario, email, senha);
        this.codCliente = codCliente;
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(String codCliente) {
        this.codCliente = codCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}

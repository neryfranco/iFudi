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
public class Vendedor extends Usuario {

    private String codVendedor;
    private String nome;
    private String cpf;

    public Vendedor(String codVendedor, String nome, String cpf, String codUsuario, String email, String senha) {
        super(codUsuario, email, senha);
        this.codVendedor = codVendedor;
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getCodVendedor() {
        return codVendedor;
    }

    public void setCodVendedor(String codVendedor) {
        this.codVendedor = codVendedor;
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

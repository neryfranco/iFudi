/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Nery
 */
public class Aluno {
    private String matricula;
    private String nome;
    private AlunoEstado estado;

    public Aluno(String matricula, String nome, String estado) {
        this.matricula = matricula;
        this.nome = nome;
        this.estado = new AlunoEstadoMatriculado();
    }

    public Aluno() {
        this.estado = new AlunoEstadoMatriculado();
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public AlunoEstado getEstado() {
        return estado;
    }

    public void setEstado(AlunoEstado estado) {
        this.estado = estado;
    }
    
    public String matricular(){
        return estado.matricular(this);
    }
    
    public String trancar(){
        return estado.trancar(this);
    }
    
    public String formar(){
        return estado.formar(this);
    }
    
    public String expulsar(){
        return estado.expulsar(this);
    }
    
    public String jubilar(){
        return estado.jubilar(this);
    }
    
    public String evadir(){
        return estado.evadir(this);
    }
}

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
public class AlunoEstadoEvadido implements AlunoEstado{

    @Override
    public String matricular(Aluno aluno) {
        aluno.setEstado(new AlunoEstadoMatriculado());
        return "Pode matricular";
    }

    @Override
    public String trancar(Aluno aluno) {
        return "Aluno Evadido não pode trancar";
    }

    @Override
    public String formar(Aluno aluno) {
        return "Aluno Evadido não pode formar";
    }

    @Override
    public String jubilar(Aluno aluno) {
        aluno.setEstado(new AlunoEstadoJubilado());
        return "Pode jubilar";
    }

    @Override
    public String expulsar(Aluno aluno) {
        return "Aluno Evadido não pode expulsar";
    }

    @Override
    public String evadir(Aluno aluno) {
        return "Aluno Evadido não pode evadir";
    }
    
}

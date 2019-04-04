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
public class AlunoEstadoMatriculado implements AlunoEstado{
    
    @Override
    public String matricular(Aluno aluno) {
        return "Aluno Matriculado não pode matricular";
    }

    @Override
    public String trancar(Aluno aluno) {
        aluno.setEstado(new AlunoEstadoTrancado());
        return "Pode trancar";
    }

    @Override
    public String formar(Aluno aluno) {
        aluno.setEstado(new AlunoEstadoFormado());
        return "Pode formar";
    }

    @Override
    public String jubilar(Aluno aluno) {
        aluno.setEstado(new AlunoEstadoJubilado());
        return "Pode jubilar";
    }

    @Override
    public String expulsar(Aluno aluno) {
        aluno.setEstado(new AlunoEstadoExpulso());
        return "Pode expulsar";
    }

    @Override
    public String evadir(Aluno aluno) {
        aluno.setEstado(new AlunoEstadoEvadido());
        return "Pode evadir";
    }
    
}

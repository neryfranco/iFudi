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
public class AlunoEstadoJubilado implements AlunoEstado{

    @Override
    public String matricular(Aluno aluno) {
        return "Aluno Jubilado não pode matricular";
    }

    @Override
    public String trancar(Aluno aluno) {
        return "Aluno Jubilado não pode trancar";
    }

    @Override
    public String formar(Aluno aluno) {
        return "Aluno Jubilado não pode formar";
    }

    @Override
    public String jubilar(Aluno aluno) {
        return "Aluno Jubilado não pode jubilar";
    }

    @Override
    public String expulsar(Aluno aluno) {
        return "Aluno Jubilado não pode expulsar";
    }

    @Override
    public String evadir(Aluno aluno) {
        return "Aluno Jubilado não pode evadir";
    }
    
}

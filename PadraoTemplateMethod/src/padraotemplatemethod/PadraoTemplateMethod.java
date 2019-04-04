/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package padraotemplatemethod;

/**
 *
 * @author Nery
 */
public class PadraoTemplateMethod {

    public static void main(String[] args) {
        
        Aluno aluno1 = new AlunoGraduacao();
        aluno1.setInstituicaoOrigem("IF");
        aluno1.setNome("JÃO");
        Aluno aluno2 = new AlunoPosGraduacao();
        aluno2.setInstituicaoOrigem("IF");
        aluno2.setNome("TOIM");
        
        System.out.println(aluno1.getDadosAluno());
        System.out.println(aluno2.getDadosAluno());
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package padraochainofresponsability;

/**
 *
 * @author Nery
 */
public class FuncionarioDiretor extends Funcionario{

    public FuncionarioDiretor(Funcionario funcionarioSuperior) {
        super(funcionarioSuperior);
        listaDocumentos.add(TipoDocumentoCertificado.getTipoDocumentoCertificado());
    }
    
    @Override
    public String getDescricaoCargo() {
        return "Diretor";
    }
    
}
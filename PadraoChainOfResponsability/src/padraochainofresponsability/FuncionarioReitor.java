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
public class FuncionarioReitor extends Funcionario{

    public FuncionarioReitor(Funcionario funcionarioSuperior) {
        super(funcionarioSuperior);
        listaDocumentos.add(TipoDocumentoDiploma.getTipoDocumentoDiploma());
    }
    
    @Override
    public String getDescricaoCargo() {
        return "Reitor";
    }
    
}

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
public class FuncionarioSecretaria extends Funcionario{

    public FuncionarioSecretaria(Funcionario funcionarioSuperior) {
        super(funcionarioSuperior);
        listaDocumentos.add(TipoDocumentoHistorico.getTipoDocumentoHistorico());
    }
    
    @Override
    public String getDescricaoCargo() {
        return "Secretaria";
    }
    
}
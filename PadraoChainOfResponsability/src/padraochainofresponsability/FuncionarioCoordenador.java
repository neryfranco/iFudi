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
public class FuncionarioCoordenador extends Funcionario{

    public FuncionarioCoordenador(Funcionario funcionarioSuperior) {
        super(funcionarioSuperior);
        listaDocumentos.add(TipoDocumentoMatricula.getTipoDocumentoMatricula());
    }
    
    @Override
    public String getDescricaoCargo() {
        return "Coordenador";
    }
    
}

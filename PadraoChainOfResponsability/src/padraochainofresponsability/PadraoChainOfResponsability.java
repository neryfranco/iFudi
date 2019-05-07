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
public class PadraoChainOfResponsability {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FuncionarioReitor reitor = new FuncionarioReitor(null);
        FuncionarioDiretor diretor = new FuncionarioDiretor(reitor);
        FuncionarioCoordenador coordenador = new FuncionarioCoordenador(diretor);
        FuncionarioSecretaria secretaria = new FuncionarioSecretaria(coordenador);
        
        System.out.println(
            secretaria.assinarDocumento(
                new Documento(TipoDocumentoHistorico.getTipoDocumentoHistorico())));
        System.out.println(
            secretaria.assinarDocumento(
                new Documento(TipoDocumentoMatricula.getTipoDocumentoMatricula())));
        System.out.println(
            secretaria.assinarDocumento(
                new Documento(TipoDocumentoCertificado.getTipoDocumentoCertificado())));
        System.out.println(
            secretaria.assinarDocumento(
                new Documento(TipoDocumentoDiploma.getTipoDocumentoDiploma())));
        System.out.println(
            secretaria.assinarDocumento(
                new Documento(TipoDocumentoBoleto.getTipoDocumentoBoleto())));
    }
    
}

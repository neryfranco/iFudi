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
public class TipoDocumentoCertificado implements TipoDocumento{
    private static TipoDocumentoCertificado tipoDocumentoCertificado = new TipoDocumentoCertificado();

    public static TipoDocumentoCertificado getTipoDocumentoCertificado() {
        return tipoDocumentoCertificado;
    }
       
}
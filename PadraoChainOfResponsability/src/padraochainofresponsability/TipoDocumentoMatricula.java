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
public class TipoDocumentoMatricula implements TipoDocumento{
    private static TipoDocumentoMatricula tipoDocumentoMatricula = new TipoDocumentoMatricula();

    public static TipoDocumentoMatricula getTipoDocumentoMatricula() {
        return tipoDocumentoMatricula;
    }
       
}
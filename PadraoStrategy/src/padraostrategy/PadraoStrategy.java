/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package padraostrategy;

/**
 *
 * @author Nery
 */
public class PadraoStrategy {

    public static void main(String[] args) {
        Produto produto1 = new TV();
        Produto produto2 = new Camera();
        Produto produto3 = new Celular();
        
        System.out.println(produto1.getNome() + 
                " na promoção " + produto1.getPromocao() +
                " com desconto de " + produto1.desconto() + "%");
        System.out.println(produto2.getNome() + 
                " na promoção " + produto2.getPromocao() +
                " com desconto de " + produto2.desconto() + "%");
        System.out.println(produto3.getNome() + 
                " na promoção " + produto3.getPromocao() +
                " com desconto de " + produto3.desconto() + "%");
    }
    
}

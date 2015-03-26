/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.tree;
/**
 *
 * @author Usuario
 */
public class Arbol {
    private NodoArbol raiz;
    public Arbol(){
        this.raiz=null;
    }
    public Arbol(NodoArbol raiz) {
        this.raiz = raiz;
    }

    public NodoArbol getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbol raiz) {
        this.raiz = raiz;
    }
    
}

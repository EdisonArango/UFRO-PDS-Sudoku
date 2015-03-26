/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.tree;

/**
 *
 * @author Usuario
 */
public class NodoArbol {
    private int[][] estado;
    public int iCambio,jCambio;
    private NodoArbol siguiente;
    private NodoArbol anterior;

    public NodoArbol(int[][] estado, int iCambio, int jCambio, NodoArbol anterior) {
        this.estado = estado;
        this.iCambio = iCambio;
        this.jCambio = jCambio;
        this.anterior = anterior;
    }
    

    public void setSiguiente(NodoArbol siguiente) {
        this.siguiente = siguiente;
    }

    public void setAnterior(NodoArbol anterior) {
        this.anterior = anterior;
    }


    public NodoArbol getSiguiente() {
        return siguiente;
    }

    public NodoArbol getAnterior() {
        return anterior;
    }

    public int[][] getEstado() {
        return estado;
    }

    public void setEstado(int[][] estado) {
        this.estado = estado;
    }
       
}

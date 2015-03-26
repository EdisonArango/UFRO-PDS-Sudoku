/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import model.tree.*;

/**
 *
 * @author edisonarango
 */
public class Sudoku {
    
    private int[][] valores;
    public Arbol arbol;

    public Sudoku(int[][] valores) {
        this.valores = valores;
    }
    
    /**
     * Agrega los numeros presentes el sudoku a un arraylist cada línea horizontal, cada línea vertical, 
     * y cada cuadrado de 3x3, si nota que al intentar agregar un nuevo numero ya esta en el array
     * se da cuenta que el sudoku no esta solucionado
     * @return boolean de sudoku solucionado o no
     */
    public boolean esValido(){
        ArrayList numeros = new ArrayList();
        
        for (int i = 0; i < 9; i++) {
            if (numeros.indexOf(valores[i][0])!=-1&&valores[i][0]!=0) {
                return false;
            }
            else{
            numeros.add(valores[i][0]);
            }
        }
        numeros.clear();
        
        for (int j = 0; j < 9; j++) {
            if (numeros.indexOf(valores[0][j])!=-1&&valores[j][0]!=0) {
                return false;
            }
            else{
            numeros.add(valores[0][j]);
            }
        }
        numeros.clear();
        
        //Rangos de los cuadrados de 3X3 Ejm: rangos[0] contiene (imenor,imayor,jmenor,jmayor) :i desde 0 hasta 3 y j desde 0 hasta 3
        String[] rangos = {"0303","3603","6903","0336","3636","6936","0369","3669","6969"};
        
        for (int k = 0; k < rangos.length; k++) {
            int imenor = Integer.valueOf(rangos[k].charAt(0)+"");
            int imayor = Integer.valueOf(rangos[k].charAt(1)+"");
            int jmenor = Integer.valueOf(rangos[k].charAt(2)+"");
            int jmayor = Integer.valueOf(rangos[k].charAt(3)+"");
            for (int i = imenor; i < imayor; i++) {
                for (int j = jmenor; j < jmayor; j++) {
                    if (numeros.indexOf(valores[i][j])!=-1&&valores[i][j]!=0) {
                    return false;
                    }
                    else{
                    numeros.add(valores[i][j]);
                    }
                }
            }
            numeros.clear();
            
        }  
        
        return true;
    }
    
    
    //Métodos de solución de sudoku
    
    public int[][] solucion(){
        arbol=new Arbol(new NodoArbol(valores,0,0,null));
        
        NodoArbol actual=arbol.getRaiz();
        
        int [][] valoresActual=valores.clone();
                for (int k = 0; k < valores.length; k++) {
                    valoresActual[k]=valores[k].clone();
        }
        
        
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (valores[i][j]==0) {
                        if (actual!=arbol.getRaiz()&&sePuedeAplicarRegla(valoresActual, i, j)==false) {
                            valoresActual[i][j]=0;
                            int [][] valoresClon=valoresActual.clone();
                            for (int k = 0; k < valoresActual.length; k++) {
                                valoresClon[k]=valoresActual[k].clone();
                            }
                            actual=actual.getAnterior();
                            actual.setEstado(valoresClon);
                                i=actual.iCambio;
                                j=actual.jCambio;
                        }
                        else{
                        valoresActual=aplicarRegla(valoresActual, i, j);
                        int [][] valoresClon=valoresActual.clone();
                            for (int k = 0; k < valoresActual.length; k++) {
                                valoresClon[k]=valoresActual[k].clone();
                            }
                        actual.setSiguiente(new NodoArbol(valoresClon,i,j,actual));
                        actual=actual.getSiguiente();
                        }
                    }  
                }
            }
            
            
        //}
        //}
        
        return actual.getEstado();
    }

    public boolean terminado(int[][] estado) {
        
        return true;       
    }
    public boolean estadoValido(int [][] estado){
        ArrayList numeros=new ArrayList();
        for (int i = 0; i < estado.length; i++) {
            for (int j = 0; j < estado.length; j++) {
                if (estado[i][j]!=0) {
                    if(numeros.indexOf(estado[i][j])==-1){
                    numeros.add(estado[i][j]);
                }
                else{
                    return false;
                }
                }   
            }
            numeros.clear();
        }
        
        for (int i = 0; i < estado.length; i++) {
            for (int j = 0; j < estado.length; j++) {
                if (estado[j][i]!=0) {
                    if(numeros.indexOf(estado[j][i])==-1){
                    numeros.add(estado[j][i]);
                }
                else{
                    return false;
                }
                }   
            }
            numeros.clear();
        }
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (estado[i][j]!=0) {
                    if(numeros.indexOf(estado[i][j])==-1){
                    numeros.add(estado[i][j]);
                }
                else{
                    return false;
                }
                }
            }
        }
            numeros.clear();
            
        
        for (int i = 0; i < 3; i++) {
            for (int j = 3; j < 6; j++) {
                if (estado[i][j]!=0) {
                    if(numeros.indexOf(estado[i][j])==-1){
                    numeros.add(estado[i][j]);
                }
                else{
                    return false;
                }
                }
            }
        }
            numeros.clear();
        
            for (int i = 0; i < 3; i++) {
            for (int j = 6; j < 9; j++) {
                if (estado[i][j]!=0) {
                    if(numeros.indexOf(estado[i][j])==-1){
                    numeros.add(estado[i][j]);
                }
                else{
                    return false;
                }
                }
            }
        }
            numeros.clear();
        
            for (int i = 3; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                if (estado[i][j]!=0) {
                    if(numeros.indexOf(estado[i][j])==-1){
                    numeros.add(estado[i][j]);
                }
                else{
                    return false;
                }
                }
            }
        }
            numeros.clear();
        
            for (int i = 3; i < 6; i++) {
            for (int j = 3; j < 6; j++) {
                if (estado[i][j]!=0) {
                    if(numeros.indexOf(estado[i][j])==-1){
                    numeros.add(estado[i][j]);
                }
                else{
                    return false;
                }
                }
            }
        }
            numeros.clear();
        
            for (int i = 3; i < 6; i++) {
            for (int j = 6; j < 9; j++) {
                if (estado[i][j]!=0) {
                    if(numeros.indexOf(estado[i][j])==-1){
                    numeros.add(estado[i][j]);
                }
                else{
                    return false;
                }
                }
            }
        }
            numeros.clear();
        
            for (int i = 6; i < 9; i++) {
            for (int j = 0; j < 3; j++) {
                if (estado[i][j]!=0) {
                    if(numeros.indexOf(estado[i][j])==-1){
                    numeros.add(estado[i][j]);
                }
                else{
                    return false;
                }
                }
            }
        }
            numeros.clear();
        
            for (int i = 6; i < 9; i++) {
            for (int j = 3; j < 6; j++) {
                if (estado[i][j]!=0) {
                    if(numeros.indexOf(estado[i][j])==-1){
                    numeros.add(estado[i][j]);
                }
                else{
                    return false;
                }
                }
            }
        }
            numeros.clear();
        for (int i = 6; i < 9; i++) {
            for (int j = 6; j < 9; j++) {
                if (estado[i][j]!=0) {
                    if(numeros.indexOf(estado[i][j])==-1){
                    numeros.add(estado[i][j]);
                }
                else{
                    return false;
                }
                }
            }
        }
            numeros.clear();
        
        return true;
    }

    public int[][] aplicarRegla(int[][] valores,int i,int j) {
        int valor=valores[i][j];
        for (int  k= 0;  k< 9-valor; k++) {
           valores[i][j]++;
           if (estadoValido(valores)) {
               break;
                
           }
        }
        return valores;
    }
    
    public boolean sePuedeAplicarRegla(int[][] valores,int i,int j){
        int [][] values=valores.clone();
        for (int k = 0; k < valores.length; k++) {
            values[k]=valores[k].clone();
        }
        for (int  k= 0;  k< 9-valores[i][j]; k++) {
           values[i][j]++;
           if (estadoValido(values)) {
                return true;
           }
        }
        return false;
    }
}

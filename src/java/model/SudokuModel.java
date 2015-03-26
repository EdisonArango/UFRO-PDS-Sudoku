/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.util.Utilidades;

/**
 *
 * @author edisonarango
 */
public class SudokuModel {
    private Sudoku sudoku;

    
    public String verificacionSudoku(String[][] valores){
        
        int[][] valoresSudoku = new int[9][9];
        
        for (int i = 0; i < valoresSudoku.length; i++) {
            for (int j = 0; j < valoresSudoku[0].length; j++) {
                String parametro = valores[i][j];
                if (parametro.equals("")) {
                    return "Existen valores vacíos";
                }
                else if (!Utilidades.isNumeric(parametro)) {
                    return "Error en los parametros";
                }
                else{
                    valoresSudoku[i][j] = Integer.valueOf(parametro);
                }
            }
        }
        
            sudoku = new Sudoku(valoresSudoku);
            String resultado;
            if (sudoku.esValido()) {
                resultado="El sudoku esta solucionado";
            }
            else{
                resultado="El sudoku no esta solucionado";
            }
            return resultado;
        
    }
    
    public int[][] solucionSudoku(String[][] valores){
        int[][] valoresSudoku = new int[9][9];
        
        for (int i = 0; i < valoresSudoku.length; i++) {
            for (int j = 0; j < valoresSudoku[0].length; j++) {
                String parametro = valores[i][j];
                if (parametro.equals("")) {
                    valoresSudoku[i][j] = 0;
                }
                else if (!Utilidades.isNumeric(parametro)) {
                    return null;
                }
                else{
                    valoresSudoku[i][j] = Integer.valueOf(parametro);
                }
            }
        }
        
        sudoku = new Sudoku(valoresSudoku);
        if (!sudoku.esValido()) {
            return null;
        }
            
            return sudoku.solucion();
            
    }
    
}

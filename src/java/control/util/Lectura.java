/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.util;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author edisonarango
 */
public class Lectura {
    
    public static String[][] leerParametros(HttpServletRequest request){
        String [][] parametros=new String[9][9];
        for (int i = 0; i < parametros.length; i++) {
            for (int j = 0; j < parametros[0].length; j++) {
                parametros[i][j]=request.getParameter(i+""+j);
            }
        }
        return parametros;
    }
    
}

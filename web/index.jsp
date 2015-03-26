<%-- 
    Document   : index
    Created on : 23-mar-2015, 14:30:41
    Author     : edisonarango
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sudoku</title>
        <link rel="stylesheet" href="css/estilos.css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js"></script> 
        <script type="text/javascript" src="js/funciones.js"></script>
    </head>
    <body>
        <center>
            <h1>Solucionador de Sudokus</h1>
            <form method="get" action="VerificarSudoku" target="frameVerificacion">           
            <div style="border: 1px solid;border-color: #DCDCDC;width: auto;">
                
                <% for (int i=0;i<9;i++){ 
                    for (int j=0;j<9;j++){
                        if ((i>2&&i<6)&&(j>=0&&j<3)||(i>=0&&i<3)&&(j>2&&j<6)||(i>2&&i<6)&&(j>=6&&j<9)||(i>=6&&i<9)&&(j>2&&j<6)) {%>
                        <% if(request.getParameter(i+""+j)!=null){ %>
                        <input class="cuadrado solo-numero" style="background-color: #CDCDCD;" type="text" maxlength="1" name="<%=i+""+j%>" value="<%= request.getAttribute(i+""+j) %>">
                        <%}
                        else{%>
                            <input class="cuadrado solo-numero" style="background-color: #CDCDCD;" type="text" maxlength="1" name="<%=i+""+j%>">
                           <% }
                        }
                        else{%>
                            <% if(request.getParameter(i+""+j)!=null){ %>
                            <input class="cuadrado solo-numero" type="text" maxlength="1" name="<%=i+""+j%>" value="<%= request.getAttribute(i+""+j) %>">
                            <%}
                            else{%>
                            <input class="cuadrado solo-numero"  type="text" maxlength="1" name="<%=i+""+j%>">
                           <% }
                        }
                    }
                %>
                    <br>
                    <%}%>
                </div>
            <br>
                <input type="submit" onclick="this.form.action='VerificarSudoku';this.form.target='frameVerificacion';" value="Verificar">
                <input type="submit" onclick="this.form.action='SolucionarSudoku';this.form.target='';" value="Solucionar">
                
        </form>
        <button onclick="borrar()">Limpiar</button>
        <br>
        <iframe style="width: 500px;height: 100px" id="frameVerificacion">
        </iframe>
        </center>
    </body>
</html>

<%-- 
    Document   : lerFrete2
    Created on : 07/04/2019, 11:00:47
    Author     : Jessica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Sistema IFood</title>
        <link href="src/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Ler Cliente</h1>
        <table class="table table-dark table-hover">
            <tr>
                <td>Código: </td> 
                <td>${frete.ID}</td>
            </tr>
            <tr>
                <td>Taxa: </td> 
                <td>${frete.taxa}</td>
            </tr>
            <tr>
                <td>Tempo de Entrega: </td> 
                <td>${frete.tempoEntrega}</td>
            </tr>
        </table>
        <a href="index.jsp"  class="btn btn-default">Voltar</a>
    </body>
</html>

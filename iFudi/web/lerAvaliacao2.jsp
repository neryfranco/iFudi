<%-- 
    Document   : lerAvaliacao2
    Created on : 07/04/2019, 10:59:33
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
        <h1>Ler Avaliação</h1>
        <table class="table table-dark table-hover">
            <tr>
                <td>Código: </td> 
                <td>${avaliacao.id}</td>
            </tr>
            <tr>
                <td>Descrição: </td> 
                <td>${avaliacao.descricao}</td>
            </tr>
            <tr>
                <td>Votação: </td> 
                <td>${avaliacao.votacao}</td>
            </tr>
        </table>
        <a href="index.jsp"  class="btn btn-default">Voltar</a>
    </body>
</html>
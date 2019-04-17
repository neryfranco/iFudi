<%-- 
    Document   : lerUsuario2
    Created on : 07/04/2019, 11:04:07
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
        <h1>Ler Usuário</h1>
        <table class="table table-dark table-hover">
            <tr>
                <td>Email: </td> 
                <td>${usuario.email}</td>
            </tr>
            <tr>
                <td>Senha: </td> 
                <td>${usuario.senha}</td>
            </tr>
        </table>
        <a href="index.jsp"  class="btn btn-default">Voltar</a>
    </body>
</html>
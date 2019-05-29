<%-- 
    Document   : lerFuncionario2
    Created on : 22/05/2019, 20:53:30
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
        <h1>Ler Funcionário</h1>
        <table class="table table-dark table-hover">
            <tr>
                <td>Email: </td> 
                <td>${funcionario.email}</td>
            </tr>
            <tr>
                <td>Senha: </td> 
                <td>${funcionario.senha}</td>
            </tr>
            <tr>
                <td>Nome: </td> 
                <td>${funcionario.nome}</td>
            </tr>
        </table>
        <a href="index.jsp"  class="btn btn-default">Voltar</a>
    </body>
</html>


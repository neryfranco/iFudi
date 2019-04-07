<%-- 
    Document   : lerRestaurante2
    Created on : 07/04/2019, 11:03:36
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
        <h1>Ler Restaurante</h1>
        <table class="table table-dark table-hover">
            <tr>
                <td>CNPJ: </td> 
                <td>${restaurante.cnpj}</td>
            </tr>
            <tr>
                <td>Nome: </td> 
                <td>${restaurante.nome}</td>
            </tr>
            <tr>
                <td>Rua: </td> 
                <td>${restaurante.rua}</td>
            </tr>
            <tr>
                <td>Número: </td> 
                <td>${restaurante.numero}</td>
            </tr>
            <tr>
                <td>Cidade: </td> 
                <td>${restaurante.cidade}</td>
            </tr>
            <tr>
                <td>Estado: </td> 
                <td>${restaurante.estado}</td>
            </tr>
            <tr>
                <td>Categoria: </td> 
                <td>${categoria.nome}</td>
            </tr>
            <tr>
                <td>Vendedor: </td> 
                <td>${vendedor.nome}</td>
            </tr>
        </table>
        <a href="index.jsp"  class="btn btn-default">Voltar</a>
    </body>
</html>
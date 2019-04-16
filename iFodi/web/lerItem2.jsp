<%-- 
    Document   : lerItem2
    Created on : 07/04/2019, 11:01:08
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
        <h1>Ler Item</h1>
        <table class="table table-dark table-hover">
            <tr>
                <td>Código: </td> 
                <td>${item.id}</td>
            </tr>
            <tr>
                <td>Quantidade: </td> 
                <td>${item.quantidade}</td>
            </tr>
            <tr>
                <td>Preço Total: </td> 
                <td>${item.precoTotal}</td>
            </tr>
            <tr>
                <td>Produto: </td> 
                <td>${produto.descricao}</td>
            </tr>
            <tr>
                <td>Pedido: </td> 
                <td>${produto.id}</td>
            </tr>
        </table>
        <a href="index.jsp"  class="btn btn-default">Voltar</a>
    </body>
</html>

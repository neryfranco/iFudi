<%-- 
    Document   : lerPedido2
    Created on : 07/04/2019, 11:01:54
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
        <h1>Ler Pedido</h1>
        <table class="table table-dark table-hover">
            <tr>
                <td>Código: </td> 
                <td>${pedido.id}</td>
            </tr>
            <tr>
                <td>Data: </td> 
                <td>${pedido.data}</td>
            </tr>
            <tr>
                <td>Avaliação: </td> 
                <td>${avaliacao.descricao}</td>
            </tr>
            <tr>
                <td>Restaurante: </td> 
                <td>${restaurante.cnpj}</td>
            </tr>
            <tr>
                <td>Frete: </td> 
                <td>${pedido.frete}</td>
            </tr>
            <tr>
                <td>Cliente: </td> 
                <td>${cliente.nome}</td>
            </tr>
        </table>
        <a href="index.jsp"  class="btn btn-default">Voltar</a>
    </body>
</html>

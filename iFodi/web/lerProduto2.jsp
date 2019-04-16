<%-- 
    Document   : lerPromoção2
    Created on : 07/04/2019, 11:02:24
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
        <h1>Ler Produto</h1>
        <table class="table table-dark table-hover">
            <tr>
                <td>Código: </td> 
                <td>${produto.id}</td>
            </tr>
            <tr>
                <td>Descrição: </td> 
                <td>${produto.descricao}</td>
            </tr>
            <tr>
                <td>Preço: </td> 
                <td>${produto.preco}</td>
            </tr>
            <tr>
                <td>Promoção: </td> 
                <td>${promocao.porcentagem}</td>
            </tr>
            <tr>
                <td>Restaurante: </td> 
                <td>${restaurante.nome}</td>
            </tr>
        </table>
        <a href="index.jsp"  class="btn btn-default">Voltar</a>
    </body>
</html>
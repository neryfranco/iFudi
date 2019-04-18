<%-- 
    Document   : lerRestaurante2
    Created on : 07/04/2019, 11:03:36
    Author     : Jessica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Sistema IFood</title>
        <link href="src/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Ler Restaurante</h1>
        <table class="table table-dark table-hover" style="width: 50%">
            <tr>
                <th>CNPJ: </th> 
                <th>Nome: </th> 
                <th>Rua: </th> 
                <th>Número: </th> 
                <th>Cidade: </th> 
                <th>Estado: </th> 
                <th>Categoria: </th>
                <th>Vendedor: </th> 
            </tr>
            <c:forEach items="${restaurantes}" var="restaurante">
                <tr>
                    <td>${restaurante.cnpj}</td>
                    <td>${restaurante.nome}</td>
                    <td>${restaurante.rua}</td>
                    <td>${restaurante.numero}</td>
                    <td>${restaurante.cidade}</td>
                    <td>${restaurante.estado}</td>
                    <td>${categoria.nome}</td>
                    <td>${vendedor.nome}</td>
                </tr>
            </c:forEach>
        </table>
        <a href="index.jsp"  class="btn btn-default">Voltar</a>
    </body>
</html>
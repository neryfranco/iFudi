<%-- 
    Document   : lerVendedor2
    Created on : 07/04/2019, 11:04:37
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
        <h1>Ler Vendedor</h1>
        <table class="table table-dark table-hover" style="width: 50%">
            <tr>
                <th>Email: </th> 
                <th>Senha: </th>
                <th>Nome: </th> 
            </tr>
            <c:forEach items="${vendedores}" var="vendedor">
                <tr>
                    <td>${vendedor.email}</td>
                    <td>${vendedor.senha}</td>
                    <td>${vendedor.nome}</td>
                </tr>
            </c:forEach>
        </table>
        <a href="index.jsp"  class="btn btn-default">Voltar</a>
    </body>
</html>
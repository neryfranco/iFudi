<%-- 
    Document   : lerPromocao2
    Created on : 07/04/2019, 11:02:56
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
        <h1>Ler Promoção</h1>
        <table class="table table-dark table-hover" style="width: 50%">
            <tr>
                <th>Código: </th> 
                <th>Descrição: </th> 
                <th>Porcentagem: </th>
            </tr>
            <c:forEach items="${promocoes}" var="promocao">
                <td>${promocao.id}</td>
                <td>${promocao.descricao}</td>
                <td>${promocao.porcentagem}</td>
                </tr>
            </c:forEach>
        </table>
        <a href="index.jsp"  class="btn btn-default">Voltar</a>
    </body>
</html>

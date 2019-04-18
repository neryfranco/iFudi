<%-- 
    Document   : lerPedido2
    Created on : 07/04/2019, 11:01:54
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
        <h1>Ler Pedido</h1>
        <table class="table table-dark table-hover" style="width: 50%">
            <tr>
                <th>Código</th> 
                <th>Data</th> 
                <th>Avaliação</th> 
                <th>Restaurante</th>
                <th>Frete</th>
                <th>Cliente</th>
            </tr>
            <c:forEach items="${pedidos}" var="pedido">
                <tr>
                    <td><c:out value="${pedido.id}"/></td>
                    <td><c:out value="${pedido.data}"/></td>
                    <td><c:out value="${avaliacao.descricao}"/></td>
                    <td><c:out value="${restaurante.cnpj}"/></td>
                    <td><c:out value="${pedido.frete}"/></td>
                    <td><c:out value="${cliente.nome}"/></td>
                </tr>
            </c:forEach>
            </table>
            <a href="index.jsp"  class="btn btn-default">Voltar</a>
        </body>
    </html>
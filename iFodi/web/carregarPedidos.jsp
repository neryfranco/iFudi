<%-- 
    Document   : pedidoStatus
    Created on : 15/04/2019, 22:09:52
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
        <h1>Lista de Pedidos</h1>
        <form action="FrontController?action=action.CarregarPedidosAction" method="post" style="width: 50%">
            <table class="table table-dark table-hover">
                <tr>
                    <th>Código: </th> 
                    <td>Restaurante: </td> 
                    <td>Cliente: </td> 
                    <td>Pedido Status: </td> 
                </tr>
                <c:forEach items="${pedidos}" var="pedido">
                <tr>
                    <td><c:out value="${pedido.id}" /></td>
                    <td><c:out value="${pedido.restaurante.nome}" /></td>
                    <td><c:out value="${pedido.cliente.email}" /></td>
                    <td><c:out value="${pedido.status}" /></td>
                </tr>
            </c:forEach>
            </table>
        </form>
    </body>
</html>
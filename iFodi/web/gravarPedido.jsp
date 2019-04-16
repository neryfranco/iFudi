<%-- 
    Document   : gravarPedido
    Created on : 06/04/2019, 22:21:11
    Author     : Jessica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema IFood</title>
        <link href="src/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Cadastro de Pedidos</h1>
        <form action="FrontController?action=action.GravarPedidoAction" method="post" style="width: 50%">
            <table class="table table-dark table-hover">
                Código:
                <input type="text" class="form-control" name="txtId"/><br/>
                Data:
                <input type="text" class="form-control" name="txtData"/><br/>
                Restaurante:
                <select class="form-control" name="optRestaurante">
                    <option value="0"></option>  
                    <c:forEach items="${restaurantes}" var="restaurante">
                        <option value="${restaurante.cnpj}">${restaurante.nome}</option>  
                    </c:forEach>
                </select> 
                Cliente:
                <select class="form-control" name="optCliente">
                    <option value="0"></option>  
                    <c:forEach items="${clientes}" var="cliente">
                        <option value="${cliente.email}">${cliente.nome}</option>  
                    </c:forEach>
                </select> 
                Frete (R$):
                <input type="text" class="form-control" name="txtFrete"/><br/>
                Tempo Estimado (min):
                <input type="text" class="form-control" name="txtTempoEntrega"/><br/>
                <input type="submit" class="btn btn-success"/>
            </table>
            <a href="index.jsp"  class="btn btn-default">Voltar</a>
        </form>
</html>

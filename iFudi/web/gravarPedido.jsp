<%-- 
    Document   : gravarPedido
    Created on : 06/04/2019, 22:21:11
    Author     : Jessica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                Avaliacao:
                <select class="form-control" name="optAvaliacao">
                    <option value="0"></option>  
                    <c:forEach items="${avaliacoes}" var="avaliacao">
                        <option value="${avaliacao.votacao}">${avaliacao.descricao}</option>  
                    </c:forEach>
                </select> 
                Restaurante:
                <select class="form-control" name="optRestaurante">
                    <option value="0"></option>  
                    <c:forEach items="${restaurantes}" var="restaurante">
                        <option value="${restaurante.nome}">${restaurante.cnpj}</option>  
                    </c:forEach>
                </select> 
                Frete:
                <select class="form-control" name="optFrete">
                    <option value="0"></option>  
                    <c:forEach items="${fretes}" var="frete">
                        <option value="${frete.taxa}">${frete.id}</option>  
                    </c:forEach>
                </select> 
                Cliente:
                <select class="form-control" name="optCliente">
                    <option value="0"></option>  
                    <c:forEach items="${clientes}" var="cliente">
                        <option value="${cliente.email}">${cliente.nome}</option>  
                    </c:forEach>
                </select> 
                <input type="submit" class="btn btn-success"/>
            </table>
            <a href="index.jsp"  class="btn btn-default">Voltar</a>
        </form>
</html>

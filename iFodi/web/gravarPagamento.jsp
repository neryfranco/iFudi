<%-- 
    Document   : gravarPagamento
    Created on : 06/04/2019, 22:21:00
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
        <h1>Cadastro de Pagamentos</h1>
        <form action="FrontController?action=action.GravarPagamentoAction" method="post" style="width: 50%">
            <table class="table table-dark table-hover">
                Código:
                <input type="text" class="form-control" name="txtId"/><br/>
                Valor:
                <input type="text" class="form-control" name="txtValor"/><br/>
                Pedido:
                <select class="form-control" name="optPedido">
                    <option value="0"></option>  
                    <c:forEach items="${pedidos}" var="pedido">
                        <option value="${pedido.tempoPreparacao}">${pedido.id}</option>  
                    </c:forEach>
                </select> 
                <input type="submit" class="btn btn-success"/>
            </table>
        </form>
</html>


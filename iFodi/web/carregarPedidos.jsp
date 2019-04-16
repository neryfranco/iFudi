<%-- 
    Document   : pedidoStatus
    Created on : 15/04/2019, 22:09:52
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
        <h1>Lista de Pedidos</h1>
        <form action="FrontController?action=action.CarregarPedidosAction" method="post" style="width: 50%">
            <table class="table table-dark table-hover">
                <tr>
                    <td>Código: </td> 
                    <td>${pedido.id}</td>
                </tr>
                <tr>
                    <td>Restaurante: </td> 
                    <td>${restaurante.cnpj}</td>
                </tr>
                <tr>
                    <td>Cliente: </td> 
                    <td>${cliente.nome}</td>
                </tr>
                <tr>
                    <td>pedido.getStatus</td>
                </tr>
            </table>
        </form>
    </body>
</html>
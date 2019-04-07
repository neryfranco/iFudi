<%-- 
    Document   : lerRestaurante
    Created on : 07/04/2019, 11:03:23
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
        <h1>Ler Restaurante</h1>
        <form action="FrontController?action=action.LerRestauranteAction" method="post" style="width: 50%">
            <table class="table table-dark table-hover">
                Entre com cnpj
                <input type="text" name="txtCnpj"/><br/>
                <input type="submit" class="btn btn-success"/>
            </table>
            <a href="index.jsp"  class="btn btn-default">Voltar</a>
        </form>
    </body>
</html>


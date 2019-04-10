<%-- 
    Document   : apagarItem
    Created on : 07/04/2019, 13:23:15
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
        <h1>Apagar Item</h1>
        <form action="FrontController?action=action.ApagarItemAction" method="post" style="width: 50%">
            <table class="table table-dark table-hover">
                Entre com código
                <input type="text" name="txtId"/><br/>
                <input type="submit" class="btn btn-success"/>
            </table>
            <a href="index.jsp"  class="btn btn-default">Voltar</a>
        </form>
    </body>
</html>
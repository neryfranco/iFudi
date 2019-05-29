<%-- 
    Document   : lerFuncionario
    Created on : 22/05/2019, 19:29:50
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
        <h1>Ler Funcionário</h1>
        <form action="FrontController?action=action.LerFuncionarioAction" method="post" style="width: 50%">
            <table class="table table-dark table-hover">
                Entre com email
                <input type="text" name="txtEmail"/><br/>
                <input type="submit" class="btn btn-success"/>
            </table>
            <a href="index.jsp"  class="btn btn-default">Voltar</a>
        </form>
    </body>
</html>

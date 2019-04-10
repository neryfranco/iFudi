<%-- 
    Document   : gravarPromocao
    Created on : 06/04/2019, 22:22:11
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
        <h1>Cadastro de Promoções</h1>
        <form action="FrontController?action=action.GravarPromocaoAction" method="post" style="width: 50%">
            <table class="table table-dark table-hover">
                Código:
                <input type="text" class="form-control"name="txtId"/><br/>
                Descrição:
                <input type="text" class="form-control" name="txtDescricao"/><br/>
                Porcentagem:
                <input type="text" class="form-control"name="txtPorcentagem"/><br/>
                <input type="submit" class="btn btn-success"/>
            </table>
            <a href="index.jsp"  class="btn btn-default">Voltar</a>
        </form>
</html>
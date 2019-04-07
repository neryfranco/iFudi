<%-- 
    Document   : gravarFrete
    Created on : 06/04/2019, 22:20:32
    Author     : Jessica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Sistema IFood</title>
        <link href="src/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Cadastro de Fretes</h1>
        <form action="FrontController?action=action.GravarFreteAction" method="post" style="width: 50%">
            <table class="table table-dark table-hover">
                Código:
                <input type="text" class="form-control" name="txtId"/><br/>
                Taxa:
                <input type="text" class="form-control" name="txtTaxa"/><br/>
                Tempo de Entrega:
                <input type="text" class="form-control" name="txtTempoEntrega"/><br/>
                <input type="submit" class="btn btn-success"/>
            </table>
            <a href="index.jsp"  class="btn btn-default">Voltar</a>
        </form>
</html>
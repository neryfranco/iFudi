<%-- 
    Document   : gravarEmpresa
    Created on : Feb 28, 2019, 9:42:19 AM
    Author     : Nery
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <h1>Cadastro de Contatos</h1>
    <form action="FrontController?action=action.GravarEmpresaAction" method="post">
        CNPJ:
        <input type="text" name="textCnpj"/><br/>
        Nome da Empresa:
        <input type="text" name="textNome"/><br/>
        <input type="submit"/>
    </form>
</html>

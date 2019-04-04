<%-- 
    Document   : apagarEmpresa
    Created on : Feb 28, 2019, 9:48:46 AM
    Author     : Nery
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Apagar Contato</h1>
        <form action="FrontController?action=action.ApagarEmpresaAction" method="post">
          Entre com CNPJ
          <input type="text" name="textCnpj"/><br/>
          <input type="submit"/>
        </form>
    </body>
</html>

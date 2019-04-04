<%-- 
    Document   : apagarContato
    Created on : Feb 26, 2019, 10:11:30 AM
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
        <form action="FrontController?action=action.ApagarContatoAction" method="post">
          Entre com email
          <input type="text" name="textEmail"/><br/>
          <input type="submit"/>
        </form>
    </body>
</html>

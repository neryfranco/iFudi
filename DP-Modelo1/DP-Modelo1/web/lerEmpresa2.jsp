<%-- 
    Document   : lerEmpresa2
    Created on : Feb 28, 2019, 9:48:35 AM
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
        <table>
            <tr>
                <td>CNPJ: </td> 
                <td>${empresa.cnpj}</td>
            </tr>
            <tr>
                <td>Nome: </td> 
                <td>${empresa.nome}</td>
            </tr>
        </table>
</body>
</html>

<%-- 
    Document   : lerContato2
    Created on : Feb 26, 2019, 10:16:59 AM
    Author     : Nery
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
    </head>
    <body>
        <table>
            <tr>
                <td>Email: </td> 
                <td>${contato.email}</td>
            </tr>
            <tr>
                <td>Nome: </td> 
                <td>${contato.nome}</td>
            </tr>
            <tr>
                <td>Empresa: </td> 
                <td>${empresa.nome}</td>
            </tr>
        </table>
</body>
</html>

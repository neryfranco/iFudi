<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%-- 
    Document   : gravarContato
    Created on : Feb 26, 2019, 10:07:03 AM
    Author     : Nery
--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <h1>Cadastro de Contatos</h1>
        <form action="FrontController?action=action.GravarContatoAction" method="post">
            Nome:
            <input type="text" name="textNome"/><br/>
            Email:
            <input type="text" name="textEmail"/><br/>
            Empresa:
                <select name="optEmpresa">
                    <option value="0"></option>  
                    <c:forEach items="${empresas}" var="empresa">
                        <option value="${empresa.cnpj}">${empresa.nome}</option>  
                    </c:forEach>
                </select> 
            <input type="submit"/>
        </form>
</html>

<%-- 
    Document   : carregarAutorizacoes
    Created on : 29/05/2019, 19:51:35
    Author     : Jessica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Sistema IFood</title>
        <link href="src/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Lista de Autorizações</h1>
        <form action="FrontController?action=action.CarregarAutorizacaoAction" method="post" style="width: 50%">
            <table class="table table-dark table-hover">
                <tr>
                    <th colspan=5>Autorizacao</th>
                </tr>
                <c:forEach items="${autorizacoes}" var="autorizacao">
                    <tr>
                        <td><a href="FrontController?action=model.AutorizacaoAdquirirBrinde=<c:out value="${autorizacao.funcao}"/>">Adquirir</a></td>
                        <td><a href="FrontController?action=model.AutorizacaoCancelarBrinde=<c:out value="${autorizacao.funcao}"/>">Cancelar</a></td>
                        <td><a href="FrontController?action=model.AutorizacaoTrocarBrinde=<c:out value="${autorizacao.funcao}"/>">Trocar</a></td>
                    </tr>
                </c:forEach>
            </table>
        </form>
        <p value="${msgPedido}">${msgPedido}</p>
        <a href="index.jsp"  class="btn btn-default">Voltar</a>
    </body>
</html>
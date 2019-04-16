<%-- 
    Document   : gravarProduto
    Created on : 06/04/2019, 22:21:25
    Author     : Jessica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema IFood</title>
        <link href="src/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Cadastro de Produtos</h1>
        <form action="FrontController?action=action.GravarProdutoAction" method="post" style="width: 50%">
            <table class="table table-dark table-hover">
                Código:
                <input type="text" class="form-control" name="txtId"/><br/>
                Descrição:
                <input type="text" class="form-control" name="txtDescricao"/><br/>
                Preço:
                <input type="text" class="form-control" name="txtPreco"/><br/>
                Promoção:
                <select class="form-control" name="optPromocao">
                    <option value="0"></option>  
                    <c:forEach items="${promocoes}" var="promocao">
                        <option value="${promocao.id}">${promocao.porcentagem}</option>  
                    </c:forEach>
                </select> 
                Restaurante:
                <select class="form-control" name="optRestaurante">
                    <option value="0"></option>  
                    <c:forEach items="${restaurantes}" var="restaurante">
                        <option value="${restaurante.cnpj}">${restaurante.nome}</option>  
                    </c:forEach>
                </select> 
                <input type="submit" class="btn btn-success"/>
            </table>
            <a href="index.jsp"  class="btn btn-default">Voltar</a>
        </form>
</html>
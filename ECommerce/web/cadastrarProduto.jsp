<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%-- 
    Document   : gravarProduto
    Created on : Feb 26, 2019, 10:07:03 AM
    Author     : Nery
--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>

        <h1>Cadastro de Produto</h1>
        <form action="FrontController?action=action.CadastrarProdutoAction" method="post">
            Codigo:
            <input type="text" name="textCodigo"/><br/>
            Nome:
            <input type="text" name="textNome"/><br/>
            Descrição:
            <input type="text" name="textDescricao"/><br/>
            Preço:
            <input type="number" step="0.01" name="textPreco"/><br/>
            <input type="submit"/>
        </form>
</html>

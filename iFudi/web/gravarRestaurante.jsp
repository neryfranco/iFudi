<%-- 
    Document   : gravarRestaurante
    Created on : 06/04/2019, 22:22:25
    Author     : Jessica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema IFood</title>
        <link href="src/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Cadastro de Restaurantes</h1>
        <form action="FrontController?action=action.GravarRestauranteAction" method="post" style="width: 50%">
            <table class="table table-dark table-hover">
                CNPJ:
                <input type="text" class="form-control" name="txtCnpj"/><br/>
                Nome:
                <input type="text" class="form-control" name="txtNome"/><br/>
                Rua:
                <input type="text" class="form-control" name="txtRua"/><br/>
                Número:
                <input type="text" class="form-control"name="txtNumero"/><br/>
                Cidade:
                <input type="text" class="form-control"name="txtCidade"/><br/>
                Estado:
                <input type="text" class="form-control" name="txtEstado"/><br/>
                Categoria:
                <select class="form-control" name="optCategoria">
                    <option value="0"></option>  
                    <c:forEach items="${categorias}" var="categoria">
                        <option value="${categoria.id}">${categoria.nome}</option>  
                    </c:forEach>
                </select> 
                Vendedor:
                <select class="form-control" name="optVendedor">
                    <option value="0"></option>  
                    <c:forEach items="${vendedores}" var="vendedor">
                        <option value="${vendedor.email}">${vendedor.nome}</option>  
                    </c:forEach>
                </select> 
                <input type="submit" class="btn btn-success"/>
            </table>
            <a href="index.jsp"  class="btn btn-default">Voltar</a>
        </form>
</html>
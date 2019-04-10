<%-- 
    Document   : gravarUsuario
    Created on : 06/04/2019, 22:22:38
    Author     : Jessica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <<title>Sistema IFood</title>
        <link href="src/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Cadastro de Usuários</h1>
        <form action="FrontController?action=action.GravarUsuarioAction" method="post" style="width: 50%">
            <table class="table table-dark table-hover">
                Email:
                <input type="text" class="form-control" name="txtEmail"/><br/>
                Senha:
                <input type="text" class="form-control" name="txtSenha"/><br/>
                Nome:
                <input type="text" class="form-control" name="txtNome"/><br/>
                CPF:
                <input type="text" class="form-control"name="txtCpf"/><br/>
                Rua:
                <input type="text" class="form-control" name="txtRua"/><br/>
                Número:
                <input type="text" class="form-control" name="txtNumero"/><br/>
                Cidade:
                <input type="text" class="form-control" name="txtCidade"/><br/>
                Estado:
                <input type="text" class="form-control" name="txtEstado"/><br/>
                <input type="submit" class="btn btn-success"/>
            </table>
            <a href="index.jsp"  class="btn btn-default">Voltar</a>
        </form>
</html>
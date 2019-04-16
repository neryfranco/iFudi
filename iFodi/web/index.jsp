<%-- 
    Document   : index.jsp
    Created on : 26/03/2019, 09:51:33
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
        <h1>Sistema iFodi</h1>
        <ul>
            <h1>Menu</h1>

            <h2>Avaliação</h2>
            <li><a href="gravarAvaliacao.jsp">Gravar</a></li>
            <li><a href="lerAvaliacao.jsp">Visualizar</a></li>
            <li><a href="apagarAvaliacao.jsp">Apagar</a></li>
            <br>
            <h2>Categoria</h2>
            <li><a href="gravarCategoria.jsp">Gravar</a></li>
            <li><a href="lerCategoria.jsp">Visualizar</a></li>
            <li><a href="apagarCategoria.jsp">Apagar</a></li>
            <br>
            <h2>Cliente</h2>
            <li><a href="gravarCliente.jsp">Gravar</a></li>
            <li><a href="lerCliente.jsp">Visualizar</a></li>
            <li><a href="apagarCliente.jsp">Apagar</a></li>
            <br>
            <h2>Frete</h2>
            <li><a href="gravarFrete.jsp">Gravar</a></li>
            <li><a href="lerFrete.jsp">Visualizar</a></li>
            <li><a href="apagarFrete.jsp">Apagar</a></li>
            <br>
            <h2>Item</h2>
            <li><a href="FrontController?action=action.PrepararGravarItemAction">Gravar</a></li>
            <li><a href="lerItem.jsp">Visualizar</a></li>
            <li><a href="apagarItem.jsp">Apagar</a></li>
            <br>
            <h2>Pagamento</h2>
            <li><a href="gravarPagamento.jsp">Gravar</a></li>
            <li><a href="lerPagamento.jsp">Visualizar</a></li>
            <li><a href="apagarPagamento.jsp">Apagar</a></li>
            <br>
            <h2>Pedido</h2>
            <li><a href="gravarPedido.jsp">Gravar</a></li>
            <li><a href="lerPedido.jsp">Visualizar</a></li>
            <li><a href="apagarPedido.jsp">Apagar</a></li>
            <br>
            <h2>Produto</h2>
            <li><a href="FrontController?action=action.PrepararGravarProdutoAction">Gravar</a></li>
            <li><a href="lerProduto.jsp">Visualizar</a></li>
            <li><a href="apagarProduto.jsp">Apagar</a></li>
            <br>
            <h2>Promoção</h2>
            <li><a href="gravarPromocao.jsp">Gravar</a></li>
            <li><a href="lerPromocao.jsp">Visualizar</a></li>
            <li><a href="apagarPromocao.jsp">Apagar</a></li>
            <br>
            <h2>Restaurante</h2>
            <li><a href="FrontController?action=action.PrepararGravarRestauranteAction">Gravar</a></li>
            <li><a href="lerRestaurante.jsp">Visualizar</a></li>
            <li><a href="apagarRestaurante.jsp">Apagar</a></li>
            <br>
            <h2>Vendedor</h2>
            <li><a href="gravarVendedor.jsp">Gravar</a></li>
            <li><a href="lerVendedor.jsp">Visualizar</a></li>
            <li><a href="apagarVendedor.jsp">Apagar</a></li>
        </ul>
    </body>
</html>
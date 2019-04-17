<%-- 
    Document   : vendedor
    Created on : 16/04/2019, 23:20:12
    Author     : Jessica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema IFood</title>
        <link href="src/css/bootstrap.min.css" rel="stylesheet" type="text/css">
        <link href="src/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="src/css/simple-sidebar.css" rel="stylesheet">
        <style>
            p{
                font-size: 18px;
            }
        </style>
    </head>
    <body>
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Área Vendedor</a>
                </div>
            </div>
        </nav>
        <br>
        <br>
        <div id="wrapper">
            <div id="sidebar-wrapper">
                <ul class="sidebar-nav">
                    <br>
                    <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Cliente">
                        <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseMulti0" data-parent="#exampleAccordion">
                            <i class="fa fa-fw fa-sitemap"></i>Cliente
                        </a>
                        <ul class="sidenav-second-level collapse" id="collapseMulti0">
                            <li>
                                <a href="lerCliente2.jsp">Visualizar</a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Avaliação">
                        <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseMulti1" data-parent="#exampleAccordion">
                            <i class="fa fa-fw fa-sitemap"></i>Avaliação
                        </a>
                        <ul class="sidenav-second-level collapse" id="collapseMulti1">
                            <li>
                                <a href="lerAvaliacao2.jsp">Visualizar</a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Categoria">
                        <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseMulti2" data-parent="#exampleAccordion">
                            <i class="fa fa-fw fa-sitemap"></i>Categoria
                        </a>
                        <ul class="sidenav-second-level collapse" id="collapseMulti2">
                            <li>
                                <a href="gravarCategoria.jsp">Gravar</a>
                            </li>
                            <li>
                                <a href="lerCategoria2.jsp">Visualizar</a>
                            </li>
                            <li>
                                <a href="apagarCategoria.jsp">Apagar</a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Frete">
                        <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseMulti3" data-parent="#exampleAccordion">
                            <i class="fa fa-fw fa-sitemap"></i>Frete
                        </a>
                        <ul class="sidenav-second-level collapse" id="collapseMulti3">
                            <li>
                                <a href="gravarFrete.jsp">Gravar</a>
                            </li>
                            <li>
                                <a href="lerFrete2.jsp">Visualizar</a>
                            </li>
                            <li>
                                <a href="apagarFrete.jsp">Apagar</a>
                            </li>
                            <br>
                        </ul>
                    </li>
                    <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Item">
                        <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseMulti4" data-parent="#exampleAccordion">
                            <i class="fa fa-fw fa-sitemap"></i>Item
                        </a>
                        <ul class="sidenav-second-level collapse" id="collapseMulti4">
                            <li>
                                <a href="FrontController?action=action.PrepararGravarItemAction">Gravar</a>
                            </li>
                            <li>
                                <a href="lerItem2.jsp">Visualizar</a>
                            </li>
                            <li>
                                <a href="apagarItem.jsp">Apagar</a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Pedido">
                        <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseMulti5" data-parent="#exampleAccordion">
                            <i class="fa fa-fw fa-sitemap"></i>Pedido
                        </a>
                        <ul class="sidenav-second-level collapse" id="collapseMulti5">
                            <li>
                                <a href="FrontController?action=action.PrepararGravarPedidoAction">Gravar</a>
                            </li>
                            <li>
                                <a href="lerPedido2.jsp">Visualizar</a>
                            </li>
                            <li>
                                <a href="FrontController?action=action.CarregarPedidosAction">Lista de Pedidos</a
                            </li>
                            <li>
                                <a href="apagarPedido.jsp">Apagar</a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Promocao">
                        <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseMulti6" data-parent="#exampleAccordion">
                            <i class="fa fa-fw fa-sitemap"></i>Promoção
                        </a>
                        <ul class="sidenav-second-level collapse" id="collapseMulti6">
                            <li>
                                <a href="gravarPromocao.jsp">Gravar</a>
                            </li>
                            <li>
                                <a href="lerPromocao2.jsp">Visualizar</a>
                            </li>
                            <li>
                                <a href="apagarPromocao.jsp">Apagar</a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Produto">
                        <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseMulti7" data-parent="#exampleAccordion">
                            <i class="fa fa-fw fa-sitemap"></i>Produto
                        </a>
                        <ul class="sidenav-second-level collapse" id="collapseMulti7">
                            <li>
                                <a href="FrontController?action=action.PrepararGravarProdutoAction">Gravar</a>
                            </li>
                            <li>
                                <a href="lerProduto2.jsp">Visualizar</a>
                            </li>
                            <li>
                                <a href="apagarProduto.jsp">Apagar</a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Restaurante">
                        <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseMulti8" data-parent="#exampleAccordion">
                            <i class="fa fa-fw fa-sitemap"></i>Restaurante
                        </a>
                        <ul class="sidenav-second-level collapse" id="collapseMulti8">
                            <li>
                                <a href="FrontController?action=action.PrepararGravarRestauranteAction">Gravar</a>
                            </li>
                            <li>
                                <a href="lerRestaurante2.jsp">Visualizar</a>
                            </li>
                            <li>
                                <a href="apagarRestaurante.jsp">Apagar</a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Restaurante">
                        <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseMulti9" data-parent="#exampleAccordion">
                            <i class="fa fa-fw fa-sitemap"></i>Restaurante
                        </a>
                        <ul class="sidenav-second-level collapse" id="collapseMulti9">
                            <li>
                                <a href="lerPagamento2.jsp">Visualizar</a>
                            </li>
                        </ul>
                    </li>
                    <li><a href="index.jsp">Sair</a></li>
                </ul>
            </div>
            <div id="page-content-wrapper">
                <div class="container-fluid">
                    <h1>Bem Vindo</h1>
                    <p>Área destinada aos vendedores do Sistema IFood.</p>
                    <a href="#menu-toggle" class="btn btn-secondary" id="menu-toggle">Acesse aqui</a>
                </div>
            </div>
        </div>
        <script src="src/vendor/jquery/jquery.min.js"></script>
        <script src="src/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script>
            $("#menu-toggle").click(function (e) {
                e.preventDefault();
                $("#wrapper").toggleClass("toggled");
            });
        </script>
    </body>
</html>



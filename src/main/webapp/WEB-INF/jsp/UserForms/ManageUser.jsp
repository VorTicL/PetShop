<%-- 
    Document   : manageFuncionario
    Created on : 10/05/2018, 15:25:23
    Author     : João
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Pet Shop</title>

        <!-- Bootstrap core CSS -->
        <link href="tools/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom fonts for this template -->
        <link href="tools/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">

        <!-- Plugin CSS -->
        <link href="tools/vendor/magnific-popup/magnific-popup.css" rel="stylesheet" type="text/css">

        <!-- Custom styles for this template -->
        <link href="tools/css/freelancer.min.css" rel="stylesheet">

        <link rel="stylesheet" type="text/css" href="tools/css/modificacao.css">

    </head>
    <body>
        <!-- Navigation -->
        <nav class="navbar navbar-expand-lg bg-secondary fixed-top text-uppercase" id="mainNav">
            <div class="container">
                <a class="navbar-brand js-scroll-trigger" href="${pageContext.request.contextPath}/home">Pet Shop</a>
                <button class="navbar-toggler navbar-toggler-right text-uppercase bg-primary text-white rounded" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    Menu
                    <i class="fa fa-bars"></i>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">

                        <li class="nav-item mx-0 mx-lg-1  dropdown show ">
                            <a class="nav-link py-3 px-0 px-lg-3 dropdown-toggled dropdown-toggle " href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Cliente</a>

                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="${pageContext.request.contextPath}/cliente">Cadastrar Cliente</a>
                                <a class="dropdown-item" href="${pageContext.request.contextPath}/searchCliente">Gerenciar Cliente</a>
                            </div>

                        </li>


                        <li class="nav-item mx-0 mx-lg-1 dropdown show">
                            <a class="nav-link py-3 px-0 px-lg-3 dropdown-toggled dropdown-toggle  " href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Produto</a>

                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="${pageContext.request.contextPath}/product">Cadastrar Produto</a>
                                <a class="dropdown-item" href="${pageContext.request.contextPath}/searchProduct">Gerenciar Produto</a>                
                            </div>

                        </li>

                        <li class="nav-item mx-0 mx-lg-1 dropdown show">
                            <a class="nav-link py-3 px-0 px-lg-3 dropdown-toggled dropdown-toggle  " href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Serviço</a>

                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="${pageContext.request.contextPath}/service">Cadastrar Serviço</a>
                                <a class="dropdown-item" href="${pageContext.request.contextPath}/searchService">Gerenciar Serviço</a>                
                            </div>
                        </li>

                        <li class="nav-item mx-0 mx-lg-1 dropdown show">
                            <a class="nav-link py-3 px-0 px-lg-3 dropdown-toggled dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Venda</a>

                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a  class="dropdown-item" href="#">Vendas</a>
                                <a class="dropdown-item" href="#">Relatório</a>               
                            </div>

                        </li>

                        <li class="nav-item mx-0 mx-lg-1">
                            <a class="dropdown nav-link py-3 px-0 px-lg-3 rounded " href="#page-top">Unidades</a>
                        </li>

                        <li class="nav-item mx-0 mx-lg-1">
                            <a class="dropdown nav-link py-3 px-0 px-lg-3 rounded " href="${pageContext.request.contextPath}/logout">SAIR</a>
                        </li>

                    </ul>
                </div>
            </div>
        </nav>

        <section class="col-md-12">
            <div class="container">
                <div class="row">
                    <div class="col-md-4" style="margin: 0 auto;">                
                        <form>
                            <div>
                                <div>
                                    <input type="number" name="idFunc" value="${func.nome}" style="visibility: hidden">
                                    <div>
                                        Nome do Funcionario: <input type="text" name="nomeFunc" value="${func.nome}"/> 
                                    </div>
                                    <div>
                                        Data de Nascimento: <input type="number" name="dataNasc" value="${prod.dataNasc}"/>
                                    </div>
                                    <div>
                                        Sexo: <input type="text" name="sexo" value="${func.sexo}"/>
                                    </div>
                                    <div>
                                        RG: <input type="number" name="rg" value="${func.rg}"/>
                                    </div> 
                                    <div>
                                        CPF: <input type="number" name="cpf" value="${func.cpf}"/>
                                    </div> 
                                    <div>
                                        <button type="submit"  action="${pageContext.request.contextPath}/manageFuncionario" method="get">
                                            Alterar
                                        </button>
                                        <button type="submit"  action="${pageContext.request.contextPath}/manageFuncionario" method="post">
                                            Excluir
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>
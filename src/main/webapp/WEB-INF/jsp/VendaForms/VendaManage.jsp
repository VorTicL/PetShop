<%-- 
    Document   : manageFuncionario
    Created on : 10/05/2018, 15:25:23
    Author     : João
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

                        <li class="nav-item mx-0 mx-lg-1 dropdown show">
                            <a class="nav-link py-3 px-0 px-lg-3 dropdown-toggled dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Usuarios</a>

                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a  class="dropdown-item" href="${pageContext.request.contextPath}user">Cadastrar Usuario</a>
                                <a class="dropdown-item" href="${pageContext.request.contextPath}/searchUser">Gerenciar Usuarios</a>               
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
            <div class="container" style="margin-top: 150px">
                <div class="row" style="margin-bottom: 50px" >
                    <h1 style="text-align: center; margin:  0 auto;">VENDA - RESUMO</h1>
                </div>
                <div class="row">

                    <div class="col-md-5" style="margin: 0 auto;">
                        <h3 style="text-align: center; margin:  0 auto;"> Cliente</h3>
                        <div class="form-group" style="display: flex">
                            <label for="formGroupExampleInput">Nome: </label>
                            <input readonly="true" type="text" class="form-control" value="${clienteV.nome}" id="nomeCli" name="nomeCli">
                        </div>
                    </div>

                    <input type="none" id="none" style="display: none" name="none" value="none" style="visibility: hidden">
                    <div class="col-md-5" style="margin: 0 auto; ">

                        <h3 style="text-align: center; margin:  0 auto;"> Produtos</h3>
                        <div class="form-group" style="display: flex">
                            <form action="${pageContext.request.contextPath}/manageVenda" method="get">
                                <input type="text" id="command2" style="display: none" name="command" value="-prod" style="visibility: hidden">
                                <c:forEach var="item" items="${venda.itens}">
                                    <input type="text" id="idProd" style="display: none" name="idProd" value="${item.produto.id}" style="visibility: hidden">
                                    <label for="formGroupExampleInput">Nome:</label>
                                    <input readonly="true" type="text" class="form-control" value="${item.produto.nome}" id="nomeCli" name="nomeCli">
                                    <label for="formGroupExampleInput">QUANTIDADE:</label>
                                    <input type="number" class="form-control" value="${item.quantidade}" onchange="setQtd('qtdProd${item.produto.id}', 'qtdProd', '${item.produto.id}')" id="qtdProd${item.produto.id}" style="width: 50px;">
                                    <label for="formGroupExampleInput">ESTOQUE:</label>
                                    <input readonly="true" type="number" class="form-control" value="${item.produto.qtdProd}" id="estoque" name="estoque">
                                    <button type="submit">X</button>
                                </c:forEach>
                            </form>
                        </div>
                    </div>
                    <div class="col-md-5" style="margin: 0 auto;">
                        <form action="${pageContext.request.contextPath}/manageVenda" method="get">
                            <h3 style="text-align: center; margin:  0 auto;"> Serviços</h3>
                            <div class="form-group" style="display: flex">
                                <input type="text" id="command" style="display: none" name="command" value="-serv" style="visibility: hidden">
                                <c:forEach var="item1" items="${venda.servList}">
                                    <input type="text" id="idServ" style="display: none" name="idServ" value="${item1.servico.id}" style="visibility: hidden">
                                    <label for="formGroupExampleInput">Nome:</label>
                                    <input readonly="true" type="text" class="form-control" value="${item1.servico.nome}" id="nomeServ" name="nomeServ">
                                    <label for="formGroupExampleInput">QUANTIDADE:</label>
                                    <input type="number" class="form-control" value="${item1.quantidade}" onchange="setQtd('qtdServ${item1.servico.id}', 'qtdServ', '${item1.servico.id}')" id="qtdServ${item1.servico.id}" style="width: 50px;">
                                    <button type="submit">X</button>
                                </c:forEach>
                            </div>
                        </form>
                    </div>
                    <form action="${pageContext.request.contextPath}/searchProductVenda" method="get">
                        <button class="btn btn-lg btn-primary btn-block" type="submit" >CARRINHO</button>    
                    </form>
                    <form action="${pageContext.request.contextPath}/manageVenda" method="get">
                        <input type="text" id="command"  name="command" value="-venda" style="visibility: hidden">
                        <button class="btn btn-lg btn-primary btn-block" type="submit" >CANCELAR VENDA</button>
                    </form>
                    <form action="${pageContext.request.contextPath}/manageVenda" method="post" >
                        <button class="btn btn-lg btn-primary btn-block" type="submit">EFETUAR VENDA</button>
                    </form>
                    <form name="valueChange" action="${pageContext.request.contextPath}/manageVenda" method="get">
                        <input type="text" id="command1"  name="command" value="" style="visibility: hidden">
                        <input type="text" id="idOb"  name="obj" value="" style="visibility: hidden">
                        <input type="text" id="qtd"  name="qtd" value="" style="visibility: hidden">
                    </form>    
                </div>
            </div>
        </section>
        <script>
            function setQtd(idOb1, com, id) {
                document.getElementById("idOb").value = id;
                document.getElementById("qtd").value = document.getElementById(idOb1).value;
                document.getElementById("command1").value = com;
                document.valueChange.submit();
            }
        </script>
        <script src="tools/vendor/jquery/jquery.min.js"></script>
        <script src="tools/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Plugin JavaScript -->
        <script src="tools/vendor/jquery-easing/jquery.easing.min.js"></script>
        <script src="tools/vendor/magnific-popup/jquery.magnific-popup.min.js"></script>

        <!-- Contact Form JavaScript -->
        <script src="tools/js/jqBootstrapValidation.js"></script>
        <script src="tools/js/contact_me.js"></script>

        <!-- Custom scripts for this template -->
        <script src="tools/js/freelancer.min.js"></script>
    </body>
</html>
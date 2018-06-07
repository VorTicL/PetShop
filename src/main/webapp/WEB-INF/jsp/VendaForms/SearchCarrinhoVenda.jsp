<%-- 
    Document   : searchCommercial
    Created on : 19/04/2018, 18:56:41
    Author     : victor.rslucca
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
            <form action="${pageContext.request.contextPath}/ServletCarrinho" method="post">
                <div class="container" style="margin-top: 150px">
                    <div class="row" style="margin-bottom: 50px" >
                        <h1 style="text-align: center; margin:  0 auto;">VENDA - CLIENTE - ADICIONAR - CARRINHO</h1>
                    </div>
                    <div class="row">
                        <div class="col-md-4" style="margin: 0 auto;">
                            <button class="btn btn-lg btn-primary btn-block" onclick="productShow" type="submit">PRODUTO</button>
                            <button class="btn btn-lg btn-primary btn-block" onclick="serviceShow"type="submit">SERVIÇO</button>
                        </div>
                    </div>    
                    <div class="row" id="product" style="display:${statusProd}">
                        <div class="col-md-4" style="margin: 0 auto;">
                            <form action="${pageContext.request.contextPath}/searchProductVenda" method="get">
                                <div class="form-group">
                                    <input type="text" class="form-control" id="nomeProd" name="nomeProd"  placeholder="PESQUISA PRODUTO">
                                    <button class="btn btn-lg btn-primary btn-block" type="submit">Pesquisar</button>
                                </div>
                            </form>
                            <form name="send" action="${pageContext.request.contextPath}/searchProductVenda" method="post">
                                <table>     
                                    <c:if test="${not empty listCommercialProduct}" >
                                        <tr>
                                            <c:forEach var="item" items="${listCommercialProduct}">
                                                <td>
                                                    <c:out value="${item.nome}"></c:out>
                                                    <button class="btn" type="button" onclick="hdnID(${item.id})">selecionar</button>
                                                </td>
                                            </c:forEach>
                                        </tr>
                                    </c:if>  
                                </table>
                                <input type="text" id="idProd"  name="idProd1" value="" style="visibility: hidden">    
                            </form>
                        </div>
                    </div>
                    <div class="row" id="service" style="display:${statusServ}">
                        <div class="col-md-4" style="margin: 0 auto;">
                            <form action="${pageContext.request.contextPath}/searchServiceVenda" method="get">
                                <div class="form-group">
                                    <input type="text" class="form-control" id="nomeServ" name="nomeServ"  placeholder="PESQUISA">
                                    <button class="btn btn-lg btn-primary btn-block" type="submit">Pesquisar</button>
                                </div>
                            </form>
                            <form name="send" action="${pageContext.request.contextPath}/searchServiceVenda" method="post">
                                <table>     
                                    <c:if test="${not empty listCommercial}" >
                                        <tr>
                                            <c:forEach var="item" items="${listCommercial}">
                                                <td>
                                                    <c:out value="${item.nome}"></c:out>
                                                    <button class="btn" type="button" onclick="hdnIDServ(${item.id})">selecionar</button>
                                                </td>
                                            </c:forEach>
                                        </tr>
                                    </c:if>  
                                </table>
                                <input type="text" id="idServ"  name="idServ1" value="" style="visibility: hidden">    
                            </form>
                        </div>
                    </div>            
                </div>
            </form>
        </section>
        <script>
            function hdnIDServ(a) {
                document.getElementById("idServ").value = a;
                document.send.submit();
            }
            function hdnIDProd(a) {
                document.getElementById("idProd").value = a;
                document.send.submit();
            }
            function productShow() {
                var y = document.getElementById("service");
                var x = document.getElementById("product");
                x.style.display = "block";
                y.style.display = "none";
            }
            function serviceShow() {
                var y = document.getElementById("service");
                var x = document.getElementById("product");
                x.style.display = "none";
                y.style.display = "block";
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

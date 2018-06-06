<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                            <a  class="dropdown-item" href="${pageContext.request.contextPath}/User/user">Cadastrar Usuario</a>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/User/searchUser">Gerenciar Usuarios</a>               
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

    <!-- Header -->
    <header class="masthead bg-primary text-white text-center">
        <div class="container">
            <img class="img-fluid mb-5 d-block mx-auto" src="tools/img/Dog-vector-now.jpg" width="230"  alt="" style="border-radius: 50%;"> 
            <h1 class="text-uppercase mb-0">Bem Vindos!</h1>
            <hr class="star-light">
            <h2 class="font-weight-light mb-0">Pet shop system</h2>
        </div>
    </header>

    <!-- 
    <section class="portfolio" id="portfolio">
      <div class="container">
        <h2 class="text-center text-uppercase text-secondary mb-0">Portfolio</h2>
        <hr class="star-dark mb-5">
        <div class="row">
          <div class="col-md-6 col-lg-4">
            <a class="portfolio-item d-block mx-auto" href="#portfolio-modal-1">
              <div class="portfolio-item-caption d-flex position-absolute h-100 w-100">
                <div class="portfolio-item-caption-content my-auto w-100 text-center text-white">
                  <i class="fa fa-search-plus fa-3x"></i>
                </div>
              </div>
              <img class="img-fluid" src="img/portfolio/cabin.png" alt="">
            </a>
          </div>
          <div class="col-md-6 col-lg-4">
            <a class="portfolio-item d-block mx-auto" href="#portfolio-modal-2">
              <div class="portfolio-item-caption d-flex position-absolute h-100 w-100">
                <div class="portfolio-item-caption-content my-auto w-100 text-center text-white">
                  <i class="fa fa-search-plus fa-3x"></i>
                </div>
              </div>
              <img class="img-fluid" src="img/portfolio/cake.png" alt="">
            </a>
          </div>
          <div class="col-md-6 col-lg-4">
            <a class="portfolio-item d-block mx-auto" href="#portfolio-modal-3">
              <div class="portfolio-item-caption d-flex position-absolute h-100 w-100">
                <div class="portfolio-item-caption-content my-auto w-100 text-center text-white">
                  <i class="fa fa-search-plus fa-3x"></i>
                </div>
              </div>
              <img class="img-fluid" src="img/portfolio/circus.png" alt="">
            </a>
          </div>
          <div class="col-md-6 col-lg-4">
            <a class="portfolio-item d-block mx-auto" href="#portfolio-modal-4">
              <div class="portfolio-item-caption d-flex position-absolute h-100 w-100">
                <div class="portfolio-item-caption-content my-auto w-100 text-center text-white">
                  <i class="fa fa-search-plus fa-3x"></i>
                </div>
              </div>
              <img class="img-fluid" src="img/portfolio/game.png" alt="">
            </a>
          </div>
          <div class="col-md-6 col-lg-4">
            <a class="portfolio-item d-block mx-auto" href="#portfolio-modal-5">
              <div class="portfolio-item-caption d-flex position-absolute h-100 w-100">
                <div class="portfolio-item-caption-content my-auto w-100 text-center text-white">
                  <i class="fa fa-search-plus fa-3x"></i>
                </div>
              </div>
              <img class="img-fluid" src="img/portfolio/safe.png" alt="">
            </a>
          </div>
          <div class="col-md-6 col-lg-4">
            <a class="portfolio-item d-block mx-auto" href="#portfolio-modal-6">
              <div class="portfolio-item-caption d-flex position-absolute h-100 w-100">
                <div class="portfolio-item-caption-content my-auto w-100 text-center text-white">
                  <i class="fa fa-search-plus fa-3x"></i>
                </div>
              </div>
              <img class="img-fluid" src="img/portfolio/submarine.png" alt="">
            </a>
          </div>
        </div>
      </div>
    </section>-->


    <!-- Bootstrap core JavaScript -->
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

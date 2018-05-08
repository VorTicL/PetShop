<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <h1>Bem vindo <c:out value="${sessionScope.usuario.email}" /></h1>
    <a href="${pageContext.request.contextPath}/logout">SAIR</a>
    <a href="${pageContext.request.contextPath}/product">Adicionar Produto</a>
    <a href="${pageContext.request.contextPath}/searchProduct">Gerenciar Produto</a>
  </body>
</html>

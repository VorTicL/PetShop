<%-- 
    Document   : responseManageFuncionario
    Created on : 10/05/2018, 15:37:30
    Author     : João
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
      
    <h1><c:out value="${response}" /></h1>
    <a href="${pageContext.request.contextPath}/searchProduct">Voltar para tela pesquisa de funcionários</a>
  </body>
</html>

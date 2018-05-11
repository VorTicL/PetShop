<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
      
    <h1><c:out value="${servResponse}" /></h1>
    <a href="${pageContext.request.contextPath}/service">Voltar para tela de cadastro de serviços</a>
  </body>
</html>

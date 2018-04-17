<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Cliente</title>
  </head>
  <body>
    <hr />
    <p>Nome:
        <c:out value="${xpto.nome}" /></p>
    <p>Data de nascimento:
      <fmt:formatDate value="${xpto.dataNascimento}" pattern="dd/MM/yyyy" /></p>
    <p>Genero:
        <c:out value="${xpto.genero}" /></p>
    <p>Telefone:
        <c:out value="${xpto.tel}" /></p>
    <p>E-mail:
        <c:out value="${xpto.email}" /></p>
  </body>
</html>

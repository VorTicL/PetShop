<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css">
	<title> Cadastrado com Sucesso!</title>
</head>
<body>
	<div class="data-container">
	<div class="success-container">
		<div>
		  <h1><c:out value="${xpto.nome}" /> FOI SALVO</h1>
		  <p>Data nascimento: <fmt:formatDate value="${xpto.dataNascimento}" pattern="dd/MM/yyyy" /></p>
		  <p>Genero: <c:out value="${xpto.genero}" /></p>
		  <p>Telefone: <c:out value="${xpto.tel}" /></p>
                  <p>E-mail: <c:out value="${xpto.email}"/></p>
		</div>
		<div>
			<a href="${pageContext.request.contextPath}/cadastro-cliente">Voltar</a>
		</div>		
	</div>	
	</div>
</body>
</html>
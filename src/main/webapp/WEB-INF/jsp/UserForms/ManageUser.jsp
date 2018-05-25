<%-- 
    Document   : manageFuncionario
    Created on : 10/05/2018, 15:25:23
    Author     : João
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<title>Gerenciar Funcionarios</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css">
</head>
<body>
    <form>
        <div class="data-container">
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
</body>
</html>
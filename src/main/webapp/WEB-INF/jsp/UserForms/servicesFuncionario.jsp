<%-- 
    Document   : servicesFuncionario
    Created on : 08/05/2018, 17:02:53
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
                    <div>
                        Nome do Funcionario: <input type="text" name="nomeFunc" value="${func.nome}"/> 
                    </div>
                    <div>
                        Data de Nascimento: <input type="number" name="dataNasc" value="${func.dataNasc}"/>
                    </div>
                    <div>
                        Sexo: <input type="text" name="sexo" value="${func.sexo}"/>
                    </div>
                    <div>
                        R.G.: <input type="text" name="rg" value="${func.rg}"/>
                    </div> 
                    <div>
                        CPF: <input type="text" name="cpf" value="${func.cpf}"/>
                    </div> 
                    <div>
                    <button type="submit"  action="http://localhost:8080/PetShop-1.0-SNAPSHOT/funcionario-serv" method="post">
                        Alterar
                    </button>
                    <button type="submit"  action="http://localhost:8080/PetShop-1.0-SNAPSHOT/funcionario-serv" method="post">
                        Excluir
                    </button>
                </div>
            </div>
        </div>
    </form>
</body>
</html>
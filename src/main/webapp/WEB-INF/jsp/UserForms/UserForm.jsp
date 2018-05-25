<%-- 
    Document   : funcionarioForm
    Created on : 08/05/2018, 15:12:59
    Author     : João
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Gerenciar Funcionario</title>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css">
    </head>
    <body>
        <form action="${pageContext.request.contextPath}/funcionario" method="post">
            <div class="data-container">
                <div>
                    <div>
                        Nome do Funcionario: <input type="text" name="nomeFunc"/> 
                    </div>
                    <div>
                        Data de Nascimento: <input type="number" name="dataNasc"/>
                    </div>
                    <div>
                        Sexo: <input type="text" name="sexo"/>
                    </div>
                    <div>
                        R.G.: <input type="text" name="rg"/>
                    </div> 
                    <div>
                        CPF: <input type="text" name="cpf"/>
                    </div> 
                    <div>
                        <button type="submit">Enviar</button>
                    </div>
                </div>
            </div>
        </form>
    </body>
</html>
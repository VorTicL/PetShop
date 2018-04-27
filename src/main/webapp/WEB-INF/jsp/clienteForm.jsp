<%-- 
    Document   : clienteForm
    Created on : 16/04/2018, 16:35:33
    Author     : João
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro Cliente</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css">
    </head>
    <body>
        <form action="${pageContext.request.contextPath}/cadastro-cliente" method="post">
         <div>
                <div>
                    <div>
                    Nome: <input type="text" name="nome"/> 
                </div>
                <div>
                    Data de nascimento: <input type="text" name="dtnasc"/>
                </div>
                <div>
                    Genero: <input type="text" name="genero"/>
                </div>
                <div>
                    Telefone: <input type="text" name="telefone"/>
                </div>
                <div>
                    E-mail: <input type="text" name="email"/>
                </div>
                <div> 
                    <button type="submit">Enviar</button>
                </div>
                </div>
            </div>
        </form>
    </body>
</html>

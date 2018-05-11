<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Gerenciar Serviços</title>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css">
    </head>
    <body>
        <form action="${pageContext.request.contextPath}/service" method="post">
            <div class="data-container">
                <div>
                    <div>
                        Nome do Serviço: <input type="text" name="nomeServ"/> 
                    </div>
                    <div>
                        Valor: <input type="number" name="uniValue"/>
                    </div>
                    <div>
                        Filial Disponivel: <input type="text" name="filial"/>
                    </div>
                    <div>
                        Pet: <input type="text" name="pet"/>
                    </div> 
                    <div>
                        <button type="submit">Enviar</button>
                    </div>
                </div>
            </div>
        </form>
        <a href="${pageContext.request.contextPath}/HomeServlet">Home</a>    
    </body>
</html>
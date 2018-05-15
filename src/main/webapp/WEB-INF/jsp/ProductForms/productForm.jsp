<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Gerenciar Produtos</title>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css">
    </head>
    <body>
        <form action="${pageContext.request.contextPath}/product" method="post">
            <div class="data-container">
                <div>
                    <div>
                        Nome do Produto: <input type="text" name="nomeProd"/> 
                    </div>
                    <div>
                        Valor Unitario: <input type="number" name="uniValue"/>
                    </div>
                    <div>
                        Filial Para Distribuição: <input type="text" name="filial"/>
                    </div>
                    <div>
                        Quantidade Em Estoque: <input type="number" name="qtdEstoque"/>
                    </div> 
                    <div>
                        <button type="submit">Enviar</button>
                    </div>
                </div>
            </div>
        </form>
        <a href="${pageContext.request.contextPath}/home">Home</a>    
    </body>
</html>
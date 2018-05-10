<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<title>Gerenciar Produtos</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css">
</head>
<body>
    <form>
        <div class="data-container">
            <div>
                <input type="number" name="idProd" value="${prod.nome}" style="visibility: hidden">
                <div>
                    Nome do Produto: <input type="text" name="nomeProd" value="${prod.nome}"/> 
                </div>
                <div>
                    Valor Unitario: <input type="number" name="uniValue" value="${prod.valor}"/>
                </div>
                <div>
                    Filial Para Distribuição: <input type="text" name="filial" value="${prod.filial}"/>
                </div>
                <div>
                    Quantidade Em Estoque: <input type="number" name="qtdEstoque" value="${prod.qtdProd}"/>
                </div> 
                <div>
                    <button type="submit"  action="http://localhost:8080/PetShop-1.0-SNAPSHOT/product-serv" method="post">
                        Alterar
                    </button>
                    <button type="submit"  action="http://localhost:8080/PetShop-1.0-SNAPSHOT/product-serv" method="post">
                        Excluir
                    </button>
                </div>
            </div>
        </div>
    </form>
</body>
</html>
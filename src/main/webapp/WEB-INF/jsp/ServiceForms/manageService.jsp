<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<title>Gerenciar Serviços</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css">
</head>
<body>
    <form action="${pageContext.request.contextPath}/manageProduct" method="get">
        <div class="data-container">
            <div>
                <input type="number" name="idProd" value="${serv.id}" style="visibility: hidden">
                <div>
                    Nome do Serviço: <input type="text" name="nomeServ" value="${serv.nome}"/> 
                </div>
                <div>
                    Valor: <input type="number" name="uniValue" value="${serv.valor}"/>
                </div>
                <div>
                    Filial Disponivel: <input type="text" name="filial" value="${serv.filial}"/>
                </div>
                <div>
                    Pet: <input type="text" name="pet" value="${serv.pet}"/>
                </div> 
                <div>
                    <button type="submit" >
                        Alterar
                    </button>
                    <button type="submit" formmethod="post">
                        Excluir
                    </button>
                </div>
            </div>
        </div>
    </form>
</body>
</html>
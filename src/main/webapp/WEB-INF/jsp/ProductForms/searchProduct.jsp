<%-- 
    Document   : searchCommercial
    Created on : 19/04/2018, 18:56:41
    Author     : victor.rslucca
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Page</title>
    </head>
    <body>
        <form action="${pageContext.request.contextPath}/searchProduct" method="get">
            <div class="data-container">
                <div>
                    <div>
                        <input type="text" name="nomeProd" value=""/> 
                    </div>
                    <div>
                        <button type="submit">Enviar</button>
                    </div>
                </div>
            </div>
        </form>
            <form name="send" action="${pageContext.request.contextPath}/searchProduct" method="post">
            <table>     

                <c:if test="${not empty listCommercial}" >
                    <tr>
                        <c:forEach var="item" items="${listCommercial}">
                            <td>
                                <c:out value="${item.nome}"></c:out>
                            </td>
                            <td>
                                <button type="button" onclick="hdnID(${item.id})">selecionar</button>
                            </td>
                        </c:forEach>
                    </tr>
                </c:if>  
            </table>
            <input id="idProd" name="idProdServ" value="" style="visibility: hidden">
            <script>
                function hdnID(a){
                    document.getElementById('idProd').value = a.toString();
                    document.send.submit();
                }
            </script>    
        </form>
        <a href="${pageContext.request.contextPath}/home">Home</a>    
    </body>
</html>

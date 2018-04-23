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
        <title>JSP Page</title>
    </head>
    <body>
        <form action="${pageContext.request.contextPath}/comm-service" method="post">
            <p id="action" hidden>search</p>
            <div class="data-container">
                <div>
                    <div>
                    <input type="text" name="nomeProd"/> 
                </div>
                <div>
                    <button type="submit">Enviar</button>
                </div>
                </div>
            </div>
        </form>
        <c:if test="${not empty listCommercial}" >   
        <table>
            <c:forEach var="objeto" items="${listCommercial}">
                <tr>
                    <td>
                        <form action="${pageContext.request.contextPath}/comm-service" method="post">
                            <input id="action" hidden>choose</p>
                            <p id="idSelected" hidden> {objeto.id}</p>
                            <button type="submit">Enviar</button>
                        </form>    
                    </td>
                    <td>
                        ${objeto.nome}
                    </td>
                    <td>
                        ${objeto.valor}
                    </td>
                </tr>
            </c:forEach>
        </table>
        </c:if>

    </body>
</html>

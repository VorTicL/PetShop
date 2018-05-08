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
        <form action="${pageContext.request.contextPath}/searchProduct" method="get">
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
            <form action="${pageContext.request.contextPath}/searchProduct" method="post">
            <table>

                </tr>     

                <c:if test="${not empty listCommercial}" >
                    <tr>
                        <c:forEach var="item" items="${listCommercial}">
                            <td>
                                <input type="text" value="${item.nome}" name="nome">
                            </td>
                            <td>
                                <button type="submit" >selecionar</button>
                            </td>
                        </c:forEach>
                    </tr>
                </c:if>  
            </table>
        </form>    
    </body>
</html>

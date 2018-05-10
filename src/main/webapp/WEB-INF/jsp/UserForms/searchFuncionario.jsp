<%-- 
    Document   : searchFuncionario
    Created on : 08/05/2018, 16:56:41
    Author     : João
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
        <form action="${pageContext.request.contextPath}/searchFuncionario" method="get">
            <div class="data-container">
                <div>
                    <div>
                        <input type="text" name="cpf"/> 
                    </div>
                    <div>
                        <button type="submit">Enviar</button>
                    </div>
                </div>
            </div>
        </form>
            <form action="${pageContext.request.contextPath}/search" method="post">
            <table>

                </tr>     

                <c:if test="${not empty listFuncionario}" >
                    <tr>
                        <c:forEach var="item" items="${listFuncionario}">
                            <td>
                                <input type="text" value="${item.cpf}" name="cpf">
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


<%-- 
    Document   : searchFuncionario
    Created on : 08/05/2018, 16:56:41
    Author     : João
--%>

<<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                        <input type="number" name="cpf"/> 
                    </div>
                    <div>
                        <button type="submit">Enviar</button>
                    </div>
                </div>
            </div>
        </form>
            <form name="send" action="${pageContext.request.contextPath}/searchFuncionario" method="post">
            <table>     

                <c:if test="${not empty listFunc}" >
                    <tr>
                        <c:forEach var="item" items="${listFunc}">
                            <td>
                                <c:out value="${item.cpf}"></c:out>
                            </td>
                            <td>
                                <button type="button" onclick="hdnID(${item.id})">selecionar</button>
                            </td>
                        </c:forEach>
                    </tr>
                </c:if>  
            </table>
            <input type="text" id="idFunc" value="" style="visibility: hidden">
            <script>
                function hdnID(a){
                    document.getElementById("idFunc").value = a;
                    document.send.submit();
                }
            </script>    
        </form>    
    </body>
</html>

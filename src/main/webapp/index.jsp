<%-- 
    Document   : login
    Created on : 05/05/2018, 23:08:55
    Author     : Victor de Lucca
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <form action="${pageContext.request.contextPath}/login" 
	    method="post">
	<div>
	  <label>Username</label>
	  <input type="text" name="username" />
	</div>
	<div>
	  <label>Senha</label>
	  <input type="password" name="senha" />
	</div>
	<button>Entrar</button>	  
      </form>
    </body>
</html>

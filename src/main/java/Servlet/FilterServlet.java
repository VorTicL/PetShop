/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Model.Entity.User;

/**
 *
 * @author Victor de Lucca
 */
@WebFilter(filterName = "filter", 
	urlPatterns = {"/UserForms","/ServiceForms", "ProductForms"},
	servletNames = {"HomeServlet", "manageProduct", "manageService", "searchProduct",
        "searchService"})
public class FilterServlet implements Filter {

  @Override
  public void init(FilterConfig filterConfig)
	  throws ServletException {

  }

  @Override
  public void doFilter(ServletRequest request,
	  ServletResponse response,
	  FilterChain chain)
	  throws IOException, ServletException {

    HttpServletRequest httpRequest = (HttpServletRequest) request;
    HttpServletResponse httpResponse = (HttpServletResponse) response;

    HttpSession sessao = httpRequest.getSession();

    // 1) Verificar se usuario esta autenticado
    if (sessao.getAttribute("usuario") == null) {
      httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");
      return;
    }
    
    chain.doFilter(request, response);
    
    User user = (User) sessao.getAttribute("usuario");

    // 2) Usuario logado, verifica se tem autorizacao para acessar recurso
    if (verificarAcesso(user, httpRequest, httpResponse)) {
      // Acesso ao recurso está liberado
      chain.doFilter(request, response);
    } else {
      // Usuario nao tem autorizacao para acessar pagina
      httpResponse.sendRedirect(httpRequest.getContextPath() + "/erro-nao-autorizado.jsp");
    }
  }

  private static boolean verificarAcesso(User user,
	  HttpServletRequest request, HttpServletResponse response) {
    String paginaAcessada = request.getRequestURI();
    String pagina = paginaAcessada.replace(request.getContextPath(), "");

    if (pagina.endsWith("/ProductForms")
	    && user.getType().compareToIgnoreCase("ESTOQUISTA") == 0) {
      return true;
    } else if (pagina.endsWith("/ServiceForms")
	    && user.getType().compareToIgnoreCase("Gerente") == 0) {
      return true;
    } else if(pagina.endsWith("/UserForm")
	    && user.getType().compareToIgnoreCase("TI") == 0) {
      return true;
    }
    return false;
  }

  @Override
  public void destroy() {

  }

}

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
	urlPatterns = {"/User/*","/ServiceForms", "ProductForms"},
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
    
    User user = (User) sessao.getAttribute("usuario");
    
    chain.doFilter(request, response);

    // 2) Usuario logado, verifica se tem autorizacao para acessar recurso
    /*if (verificarAcesso(user, httpRequest, httpResponse)) {
      // Acesso ao recurso está liberado
      chain.doFilter(request, response);
    } else {
      // Usuario nao tem autorizacao para acessar pagina
      httpResponse.sendRedirect(httpRequest.getContextPath() + "/erro-autorizado.jsp");
    }*/
  }

  private static boolean verificarAcesso(User user,
	  HttpServletRequest request, HttpServletResponse response) {
    String paginaAcessada = request.getRequestURI();
    String pagina = paginaAcessada.replace(request.getContextPath(), "");

    if (pagina.endsWith("/ProductForms")
	    && user.getType().compareToIgnoreCase("ESTOQUISTA") != 0
            || user.getType().compareToIgnoreCase("admin") != 0) {
      return false;
    } else if (pagina.endsWith("/ServiceForms") || pagina.endsWith("/ClienteForm")
	    && (user.getType().compareToIgnoreCase("GERENTE") !=0 || user.getType().compareToIgnoreCase("VENDEDOR") != 0
            || user.getType().compareToIgnoreCase("admin") != 0)) {
      return false;
    } else if(pagina.startsWith("/User")
	    && (user.getType().compareToIgnoreCase("TI") == 0 || user.getType().compareToIgnoreCase("admin") == 0)) {
      return true;
    }
    
    return true;
  }

  @Override
  public void destroy() {

  }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javadbc.petshoppi.model;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author João
 */
@WebServlet(name = "CadastroClienteMVCServlet", urlPatterns = {"/cadastro-cliente"})
public class CadastroClienteMVCServlet  extends HttpServlet{
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {

    HttpSession sessao = request.getSession();

    Object c = sessao.getAttribute("xpto");
    if (c != null) {
      request.setAttribute("xpto", c);
      sessao.removeAttribute("xpto");
      RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/cliente-resultado.jsp");
      dispatcher.forward(request, response);
    } else {
      RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/clienteForm.jsp");
      dispatcher.forward(request, response);
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
    String nome = request.getParameter("nome");
    String dataNascimento = request.getParameter("dtnasc");
    String genero = request.getParameter("genero");
    String tel = request.getParameter("tel");
    String email = request.getParameter("email");

    ModelCommercialCliente c = new ModelCommercialCliente(nome,dataNascimento,genero,tel,email);

    HttpSession sessao = request.getSession();
    sessao.setAttribute("xpto", c);
    response.sendRedirect(request.getContextPath() + "/cadastro-cliente");

  }
}

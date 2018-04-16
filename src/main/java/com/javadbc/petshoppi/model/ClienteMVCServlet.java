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

/**
 *
 * @author João
 */
@WebServlet(name = "ClienteMVCServlet", urlPatterns = {"/cliente-mvc"})
public class ClienteMVCServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
    
    String nome = request.getParameter("nome");
    String dataNascimento = request.getParameter("dtnasc");
    String genero = request.getParameter("genero");
    String tel = request.getParameter("tel");
    String email = request.getParameter("email");
    
    ModelCommercialCliente p1 = new ModelCommercialCliente(nome, dataNascimento, genero,tel,email);
    request.setAttribute("xpto", p1);

    RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/cliente-mvc.jsp");
    dispatcher.forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {

  }

}

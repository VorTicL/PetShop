/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javadbc.petshoppi.model;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author victor.rslucca
 */
@WebServlet(name = "CommercialProductServlet", urlPatterns = {"/product-serv"})
public class CommercialProductServlet extends HttpServlet{

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
    
    String nome = request.getParameter("nomeProd");
    double valueUni = Double.parseDouble(request.getParameter("uniValue"));
    String filial = request.getParameter("filial");
    int qtdEstoque = Integer.parseInt(request.getParameter("qtdEstoque"));
    
    ModelCommercialProduct prod1 = new ModelCommercialProduct(nome, valueUni, filial, qtdEstoque);
    request.setAttribute("xpto", "Produto Cadastrado com sucesso!");

    RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/cliente-mvc.jsp");
    dispatcher.forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {

  }

}

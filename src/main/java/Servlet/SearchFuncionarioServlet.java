/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Model.Entity.Funcionario;
import ServiceMock.MockFuncionario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "SearchFuncionario", urlPatterns = {"/searchFuncionario"})
public class SearchFuncionarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = "";
        nome = request.getParameter("nomeFunc");
        
        if (nome != null) {
            ArrayList<Funcionario> listFunc = MockFuncionario.buscarPorNome(nome);
            request.setAttribute("listFunc", listFunc);
        }
            
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/UserForms/searchFuncionario.jsp");
        dispatcher.forward(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
          try {
        int idFunc = Integer.parseInt(request.getParameter("idFuncServ"));
            
        Funcionario func1 = MockFuncionario.buscarPorId(idFunc);
        
        request.setAttribute("func", func1);
        
        request.getRequestDispatcher("WEB-INF/jsp/UserForms/manageFuncionario.jsp")
                    .forward(request, response);
        } catch (Exception e) {
            request.getRequestDispatcher("WEB-INF/jsp/UserForms/searchFuncionario.jsp")
                    .forward(request, response);
        }
        
    }

    

}

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
        String cpf = "";
        cpf = request.getParameter("cpf");
        
        if (cpf != null) {
            ArrayList<Funcionario> listFuncionario = MockFuncionario.buscarPorCpf(cpf);
            request.setAttribute("listFuncionario", listFuncionario);
        }
            
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/CommercialForms/searchFuncionario.jsp");
        dispatcher.forward(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         String cpf = request.getParameter("cpf");
        
         ArrayList func1 = MockFuncionario.buscarPorCpf(cpf);
        
        request.setAttribute("func", func1);
        
        request.getRequestDispatcher("WEB-INF/jsp/CommercialForms/servicesFuncionario.jsp")
                    .forward(request, response);
        
    }

    

}

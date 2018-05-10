/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import ServiceMock.MockFuncionario;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rafaela Aquino
 */
@WebServlet(name = "ManageProduct", urlPatterns = {"/manageProduct"})
public class ManageProductServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         String cpf = request.getParameter("cpf");
        
         ArrayList func1 = MockFuncionario.buscarPorCpf(cpf);
        
        request.setAttribute("func", func1);
        
        request.getRequestDispatcher("WEB-INF/jsp/CommercialForms/servicesForm.jsp")
                    .forward(request, response);
        
    }
}

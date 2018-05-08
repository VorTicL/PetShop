/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Model.Entity.ModelCommercialProduct;
import ServiceMock.MockProduto;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author joao.vrevangelista
 */
@WebServlet(name = "searchProduct", urlPatterns = {"/searchProduct"})
public class SearchProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nomeProd = "";
        nomeProd = request.getParameter("nomeProd");
        
        if (nomeProd != null) {
            ArrayList<ModelCommercialProduct> listCommercial = MockProduto.buscarPorUsername(nomeProd);
            request.setAttribute("listCommercial", listCommercial);
        }
            
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/CommercialForms/searchCommercial.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        
        ModelCommercialProduct prod1 = MockProduto.buscarPorNome(nome);
        
        request.setAttribute("prod", prod1);
        
        request.getRequestDispatcher("WEB-INF/jsp/CommercialForms/servicesForm.jsp")
                    .forward(request, response);
        
    }

}

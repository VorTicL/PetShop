/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Model.Entity.ModelCommercialProduct;
import ServiceMock.MockFuncionario;
import ServiceMock.MockProduto;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rafaela Aquino
 */
@WebServlet(name = "ManageProduct", urlPatterns = {"/manageProduct"})
public class ManageProductServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            
        
        ModelCommercialProduct modelCommercialProduct = new ModelCommercialProduct();
        modelCommercialProduct.setId(Integer.parseInt(request.getParameter("idProd")));
        modelCommercialProduct.setFilial(request.getParameter("filial"));
        modelCommercialProduct.setNome(request.getParameter("nomeProd"));
        modelCommercialProduct.setQtdProd(Integer.parseInt(request.getParameter("qtdEstoque")));
        modelCommercialProduct.setValor(Double.parseDouble(request.getParameter("uniValue")));
        
        MockProduto.alterar(modelCommercialProduct);
        
        request.setAttribute("response", "Produto Alterado Com Sucesso!");
        } catch (Exception e) {
            request.setAttribute("response", "ERRO!");
        }
        request.getRequestDispatcher("WEB-INF/jsp/CommercialForms/responseManageProduct.jsp")
                    .forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         try {
        int idRemove = Integer.parseInt(request.getParameter("idProd"));
             MockProduto.remover(idRemove);
        request.setAttribute("response", "Produto Removido Com Sucesso!");
        } catch (Exception e) {
            request.setAttribute("response", "ERRO!");
        }
        request.getRequestDispatcher("WEB-INF/jsp/CommercialForms/responseManageProduct.jsp")
                    .forward(request, response);
        
    }
}

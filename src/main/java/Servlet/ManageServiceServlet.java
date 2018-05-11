/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Model.Entity.ModelCommercialProduct;
import Model.Entity.ModelCommercialService;
import ServiceMock.MockFuncionario;
import ServiceMock.MockProduto;
import ServiceMock.MockService;
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
@WebServlet(name = "manageService", urlPatterns = {"/manageService"})
public class ManageServiceServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            
        
            ModelCommercialService modelCommercialService = new ModelCommercialService();
        modelCommercialService.setId(Integer.parseInt(request.getParameter("idProd")));
        modelCommercialService.setFilial(request.getParameter("filial"));
        modelCommercialService.setNome(request.getParameter("nomeServ"));
        modelCommercialService.setPet(request.getParameter("pet"));
        modelCommercialService.setValor(Double.parseDouble(request.getParameter("uniValue")));
        
            MockService.alterar(modelCommercialService);
        
        request.setAttribute("response", "Serviço Alterado Com Sucesso!");
        } catch (Exception e) {
            request.setAttribute("response", "ERRO!");
        }
        request.getRequestDispatcher("WEB-INF/jsp/ServiceForms/responseManageService.jsp")
                    .forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         try {
        int idRemove = Integer.parseInt(request.getParameter("idServ"));
             MockService.remover(idRemove);
        request.setAttribute("response", "Serviço Removido Com Sucesso!");
        } catch (Exception e) {
            request.setAttribute("response", "ERRO!");
        }
        request.getRequestDispatcher("WEB-INF/jsp/ServiceForms/responseManageService.jsp")
                    .forward(request, response);
        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Model.DAO.ModelCommercialServicosDao;
import Model.Entity.ModelCommercialProduct;
import Model.Entity.ModelCommercialService;
import ServiceMock.MockProduto;
import ServiceMock.MockService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Victor de Lucca
 */
@WebServlet(name = "searchService", urlPatterns = {"/searchService"})
public class SearchServiceServlet extends HttpServlet {

    ModelCommercialServicosDao modelCommercialServicosDao = null;
    List<ModelCommercialService> listCommercial = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nomeServ = null;
        nomeServ = request.getParameter("nomeServ");
        try {

            if (nomeServ != null) {
                if (nomeServ.compareToIgnoreCase("") != 0) {
                    listCommercial = modelCommercialServicosDao.selectNameServices(nomeServ);
                } else {
                    listCommercial = modelCommercialServicosDao.selectAllServices();
                }

            }
            
            request.setAttribute("listCommercial", listCommercial);

        } catch (Exception e) {
            listCommercial = null;
            request.setAttribute("listCommercial", listCommercial);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/ServiceForms/searchService.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int idServ = Integer.parseInt(request.getParameter("idServ"));

            ModelCommercialService serv1 = modelCommercialServicosDao.selectIdServices(idServ);

            request.setAttribute("serv", serv1);

            request.getRequestDispatcher("WEB-INF/jsp/ServiceForms/manageService.jsp")
                    .forward(request, response);
        } catch (Exception e) {
            request.getRequestDispatcher("WEB-INF/jsp/ServiceForms/searchService.jsp")
                    .forward(request, response);
        }

    }

}

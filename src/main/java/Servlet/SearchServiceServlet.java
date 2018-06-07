/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Model.DAO.ModelCommercialServicosDao;
import Model.Entity.ModelCommercialService;
import java.io.IOException;
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

    ModelCommercialServicosDao modelCommercialServicosDao = new ModelCommercialServicosDao();
    List<ModelCommercialService> listCommercial = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nomeServ = "";
        nomeServ = request.getParameter("nomeServ");
        try {
            if (nomeServ == null || nomeServ.compareToIgnoreCase("") == 0) {
                listCommercial = modelCommercialServicosDao.selectAllServices();
            } else {
                listCommercial = modelCommercialServicosDao.selectNameServices(nomeServ);
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
            int idServ = Integer.parseInt(request.getParameter("idServ1"));

            ModelCommercialService serv = modelCommercialServicosDao.selectIdServices(idServ);

            request.setAttribute("serv", serv);

            request.getRequestDispatcher("WEB-INF/jsp/ServiceForms/manageService.jsp")
                    .forward(request, response);
        } catch (Exception e) {
            request.getRequestDispatcher("WEB-INF/jsp/ServiceForms/searchService.jsp")
                    .forward(request, response);
        }

    }

}

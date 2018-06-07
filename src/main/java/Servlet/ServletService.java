/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Model.DAO.ModelCommercialServicosDao;
import Model.Entity.ModelCommercialService;
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
@WebServlet(name = "serviceServlet", urlPatterns = {"/service"})
public class ServletService extends HttpServlet {
    
    ModelCommercialServicosDao ModelCommercialServicosDao = new ModelCommercialServicosDao();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp"
                + "/ServiceForms/serviceForm.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String nome = request.getParameter("nome");
            double valueUni = Double.parseDouble(request.getParameter("valor"));
            String filial = request.getParameter("filial");
            String pet =request.getParameter("pet");

            ModelCommercialService serv1 = new ModelCommercialService(pet, valueUni, nome, Integer.parseInt(filial));
            if (ModelCommercialServicosDao.insertService(serv1)) {
                request.setAttribute("response", serv1.getNome() + " Cadastrado com sucesso!");
            } else {
                request.setAttribute("response", "ERRO!");
            }
            request.setAttribute("response",  serv1.getNome()+" Cadastrado com sucesso!");
        } catch (Exception e) {
            request.setAttribute("response", "ERRO!");
        }finally{
            request.getRequestDispatcher("WEB-INF/jsp/ServiceForms/responseInsertService.jsp")
                    .forward(request, response);
        }
    }

}

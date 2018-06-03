/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Model.DAO.ModelCommercialProductDao;
import Model.Entity.ModelCommercialProduct;
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
@WebServlet(name = "searchProduct", urlPatterns = {"/searchProduct"})
public class SearchProductServlet extends HttpServlet {

    ModelCommercialProductDao modelCommercialProductDao = new ModelCommercialProductDao();
    List<ModelCommercialProduct> listCommercial = new ArrayList<ModelCommercialProduct>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nomeProd = request.getParameter("nomeProd");
        
        try {
            if (nomeProd == null || nomeProd.compareToIgnoreCase("") == 0) {
            
                listCommercial = modelCommercialProductDao.selectAllProducts();
            
            } else {
                
                listCommercial = modelCommercialProductDao.selectNameProducts(nomeProd);
            
            }
            
            request.setAttribute("listCommercial", listCommercial);
            
        } catch (Exception e) {
            
            request.setAttribute("listCommercial", listCommercial);
            
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/ProductForms/searchProduct.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int idProd = Integer.parseInt(request.getParameter("idProdServ"));

            ModelCommercialProduct prod1 = modelCommercialProductDao.selectIdProduct(idProd);

            request.setAttribute("prod", prod1);

            request.getRequestDispatcher("WEB-INF/jsp/ProductForms/manageProduct.jsp")
                    .forward(request, response);
        } catch (Exception e) {
            request.getRequestDispatcher("WEB-INF/jsp/ProductForms/searchProduct.jsp")
                    .forward(request, response);
        }

    }

}

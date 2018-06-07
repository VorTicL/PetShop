/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Model.DAO.ModelCommercialProductDao;
import Model.Entity.ModelCommercialProduct;
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
@WebServlet(name = "CommercialProductServlet", urlPatterns = {"/product"})
public class ServletProduct extends HttpServlet {

    ModelCommercialProductDao modelCommercialProductDao = new ModelCommercialProductDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp"
                + "/ProductForms/productForm.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ModelCommercialProduct prod = new ModelCommercialProduct();
        try {
            prod.setNome(request.getParameter("nomeProd"));
            prod.setValor(Double.parseDouble(request.getParameter("uniValue")));
            prod.setFilial(Integer.parseInt(request.getParameter("filial")));
            prod.setQtdProd(Integer.parseInt(request.getParameter("qtdEstoque")));

          ModelCommercialProductDao productDAO = new ModelCommercialProductDao();
            if (productDAO.insertProduct(prod)) {
                request.setAttribute("response", "Produto Adicionado Com Sucesso");
            } else {
                request.setAttribute("response", "ERRO!");
            }
        } catch (Exception e) {
            request.setAttribute("response", "ERRO!");
        }
        request.getRequestDispatcher("WEB-INF/jsp/ProductForms/responseInsertProduct.jsp").forward(request, response);

    }

}

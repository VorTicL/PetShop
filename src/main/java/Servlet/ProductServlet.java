/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Model.DAO.ModelCommercialProductDao;
import Model.Entity.ModelCommercialProduct;
import ServiceMock.MockProduto;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author victor.rslucca
 */
@WebServlet(name = "CommercialProductServlet", urlPatterns = {"/product"})
public class ProductServlet extends HttpServlet {

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

        //ModelCommercialProduct produto = new ModelCommercialProduct(
        //request.getParameter("nomeProd"),Double.parseDouble(request.getParameter("uniValue")),
        //request.getParameter("filial"),Integer.parseInt(request.getParameter("qtdEstoque")));
        //ModelCommercialProductDao produtoDao = new  ModelCommercialProductDao();
        //int id = produtoDao.insert(produto);
        //request.getRequestDispatcher("WEB-INF/jsp/ProductForms/productForm.jsp").forward(request, response);
        try {
            String nome = request.getParameter("nomeProd");
            double valueUni = Double.parseDouble(request.getParameter("uniValue"));
            String filial = request.getParameter("filial");
            int qtdEstoque = Integer.parseInt(request.getParameter("qtdEstoque"));

            ModelCommercialProduct prod1 = new ModelCommercialProduct(nome, valueUni, filial, qtdEstoque);
            if (modelCommercialProductDao.insertProduct(prod1)) {
                request.setAttribute("productResponse", prod1.getNome() + "Cadastrado com sucesso!");
            } else {
                request.setAttribute("productResponse", "ERRO!");
            }
        } catch (Exception e) {
            request.setAttribute("productResponse", "ERRO!");
        } finally {
            request.getRequestDispatcher("WEB-INF/jsp/ProductForms/responseInsertProduct.jsp")
                    .forward(request, response);
        }

    }

}
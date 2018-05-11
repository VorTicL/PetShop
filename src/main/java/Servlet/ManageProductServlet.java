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
public class ManageProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("idProd"));
            String filial = request.getParameter("filial");
            String nome = request.getParameter("nomeProd");
            int qtd = Integer.parseInt(request.getParameter("qtdEstoque"));
            double valor = Double.parseDouble(request.getParameter("uniValue"));
            ModelCommercialProduct modelCommercialProduct = new ModelCommercialProduct();
            modelCommercialProduct.setId(id);
            modelCommercialProduct.setFilial(filial);
            modelCommercialProduct.setNome(nome);
            modelCommercialProduct.setQtdProd(qtd);
            modelCommercialProduct.setValor(valor);

            MockProduto.alterar(modelCommercialProduct);

            request.setAttribute("response", "Produto Alterado Com Sucesso!");
        } catch (Exception e) {
            request.setAttribute("response", "ERRO!");
        }
        request.getRequestDispatcher("WEB-INF/jsp/ProductForms/responseManageProduct.jsp")
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
        request.getRequestDispatcher("WEB-INF/jsp/ProductForms/responseManageProduct.jsp")
                .forward(request, response);

    }
}

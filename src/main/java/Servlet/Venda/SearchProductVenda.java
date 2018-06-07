/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet.Venda;

import Servlet.*;
import Model.DAO.ModelCommercialProductDao;
import Model.Entity.ItensVenda;
import Model.Entity.ModelCommercialProduct;
import Model.Entity.Venda;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Victor de Lucca
 */
@WebServlet(name = "searchProductVenda", urlPatterns = {"/searchProductVenda"})
public class SearchProductVenda extends HttpServlet {

    ModelCommercialProductDao modelCommercialProductDao = new ModelCommercialProductDao();
    List<ModelCommercialProduct> listCommercialProd = new ArrayList<ModelCommercialProduct>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nomeProd = request.getParameter("nomeProd");

        try {
            if (nomeProd == null || nomeProd.compareToIgnoreCase("") == 0) {

                listCommercialProd = modelCommercialProductDao.selectAllProducts();

            } else {

                listCommercialProd = modelCommercialProductDao.selectNameProducts(nomeProd);

            }

            request.setAttribute("listCommercial", listCommercialProd);

        } catch (Exception e) {

            request.setAttribute("listCommercial", listCommercialProd);

        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/VendaForms/SearchCarrinhoVenda.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        Venda venda = (Venda) sessao.getAttribute("venda");
        List<ItensVenda> itens = null;
        try {
            
            int idProd = Integer.parseInt(request.getParameter("idProdServ"));

            ModelCommercialProduct prod1 = modelCommercialProductDao.selectIdProduct(idProd);
            ItensVenda itensV = new ItensVenda();
            itensV.setIdProd(prod1);
            itensV.setValorUni(prod1.getValor());
            if (venda.getItens() == null) {
                itens = new ArrayList<>();
            } else {
                itens = venda.getItens();
            }
            
            itens.add(itensV);
            
            venda.setItens(itens);
            sessao.removeAttribute("venda");
            sessao.setAttribute("venda", venda);

            request.getRequestDispatcher("WEB-INF/jsp/VendaForms/Managevenda.jsp")
                    .forward(request, response);
        } catch (Exception e) {
            request.getRequestDispatcher("WEB-INF/jsp/VendaForms/SearchCarrinhoVenda.jsp")
                    .forward(request, response);
        }

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Model.DAO.ModelCommercialProductDao;
import Model.Entity.ModelCommercialProduct;
import java.io.IOException;
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
@WebServlet(name = "ManageProduct", urlPatterns = {"/manageProduct"})
public class ManageProductServlet extends HttpServlet {

    ModelCommercialProductDao modelCommercialProductDao =new ModelCommercialProductDao();
    
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

       try {
            HttpSession sessao = request.getSession();

            ModelCommercialProduct prod = (ModelCommercialProduct) sessao.getAttribute("manageProduct");
            
            prod.setNome(request.getParameter("nomeProd"));
            prod.setValor(Double.parseDouble(request.getParameter("uniValue")));
            prod.setFilial(Integer.parseInt(request.getParameter("filial")));
            prod.setQtdProd(Integer.parseInt(request.getParameter("qtdEstoque")));

            
            if (modelCommercialProductDao.updateProduct(prod)) {
                request.setAttribute("response", "Produto Alterado Com Sucesso!");
            }else{
                request.setAttribute("response", "ERRO!");
            }
            
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
            if (modelCommercialProductDao.deleteProduct(idRemove)) {
                request.setAttribute("response", "Produto Removido Com Sucesso!");
            }else{
                request.setAttribute("response", "ERRO!");
            }
        } catch (Exception e) {
            request.setAttribute("response", "ERRO!");
        }
        request.getRequestDispatcher("WEB-INF/jsp/ProductForms/responseManageProduct.jsp")
                .forward(request, response);

    }
}

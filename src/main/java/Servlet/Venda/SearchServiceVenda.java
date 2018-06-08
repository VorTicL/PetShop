/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet.Venda;

import Servlet.*;
import Model.DAO.ModelCommercialServicosDao;
import Model.Entity.ItensVenda;
import Model.Entity.ModelCommercialProduct;
import Model.Entity.ModelCommercialService;
import Model.Entity.ServicosList;
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
@WebServlet(name = "searchService", urlPatterns = {"/searchServiceVenda"})
public class SearchServiceVenda extends HttpServlet {

    ModelCommercialServicosDao modelCommercialServicosDao = new ModelCommercialServicosDao();
    List<ModelCommercialService> listCommercialServ = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nomeServ = "";
        nomeServ = request.getParameter("nomeServ");
        try {
            if (nomeServ == null || nomeServ.compareToIgnoreCase("") == 0) {
                listCommercialServ = modelCommercialServicosDao.selectAllServices();
            } else {
                listCommercialServ = modelCommercialServicosDao.selectNameServices(nomeServ);
            }
            request.setAttribute("statusProd", "none");
            request.setAttribute("statusServ", "block");
            request.setAttribute("listCommercialServ", listCommercialServ);

        } catch (Exception e) {
            listCommercialServ = null;
            request.setAttribute("listCommercialServ", listCommercialServ);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/VendaForms/SearchCarrinhoVenda.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        Venda venda = (Venda) sessao.getAttribute("venda");
        List<ServicosList> itens = null;

        try {

            int idServ = Integer.parseInt(request.getParameter("idServ1"));

            ModelCommercialService serv = modelCommercialServicosDao.selectIdServices(idServ);
            ServicosList itensV = new ServicosList();
            itensV.setServico(serv);
            itensV.setValorUni(serv.getValor());
            itensV.setQuantidade(itensV.getQuantidade()+1);
            if (venda.getServList() == null) {
                itens = new ArrayList<>();
            } else {
                itens = venda.getServList();
            }

            itens.add(itensV);

            venda.setServList(itens);
            sessao.removeAttribute("venda");
            sessao.setAttribute("venda", venda);
        } catch (Exception e) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/VendaForms/SearchCarrinhoVenda.jsp");
            dispatcher.forward(request, response);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/VendaForms/VendaManage.jsp");
            dispatcher.forward(request, response);
    }

}

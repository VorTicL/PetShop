/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet.Venda;

import Servlet.*;
import Model.DAO.ModelCommercialServicosDao;
import Model.DAO.VendaDAO;
import Model.Entity.ModelCommercialService;
import Model.Entity.Venda;
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
@WebServlet(name = "manageVenda", urlPatterns = {"/manageVenda"})
public class ManageServiceVenda extends HttpServlet {

    ModelCommercialServicosDao modelCommercialServicosDao = new ModelCommercialServicosDao();

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        try {
            HttpSession sessao = request.getSession();
            String command = "";
            command = request.getParameter("command");

            if (command.compareToIgnoreCase("-prod") == 0) {
                Venda venda = (Venda) sessao.getAttribute("venda");

                for (int i = 0; i < venda.getItens().size(); i++) {
                    if (venda.getItens().get(i).getIdProd().getId() == Integer.parseInt(request.getParameter("idProd"))) {
                        venda.getItens().remove(i);
                        request.getRequestDispatcher("WEB-INF/jsp/VendaForms/VendaManage.jsp")
                                .forward(request, response);
                        return;
                    }
                }
            } else if (command.compareToIgnoreCase("-serv") == 0) {
                Venda venda = (Venda) sessao.getAttribute("venda");

                for (int i = 0; i < venda.getServList().size(); i++) {
                    if (venda.getServList().get(i).getServico().getId() == Integer.parseInt(request.getParameter("idServ"))) {
                        venda.getServList().remove(i);
                        request.getRequestDispatcher("WEB-INF/jsp/VendaForms/VendaManage.jsp")
                                .forward(request, response);
                        return;
                    }
                }
            } else if (command.compareToIgnoreCase("-venda") == 0) {
                sessao.removeAttribute("venda");
                sessao.removeAttribute("clienteV");
                request.getRequestDispatcher("WEB-INF/jsp/home.jsp")
                .forward(request, response); 
                return;
            }else if(command.compareToIgnoreCase("qtdServ") == 0){
                Venda venda = (Venda) sessao.getAttribute("venda");

                for (int i = 0; i < venda.getServList().size(); i++) {
                    if (venda.getServList().get(i).getServico().getId() == Integer.parseInt(request.getParameter("obj"))) {
                        venda.getServList().get(i).setQuantidade(Integer.parseInt(request.getParameter("qtd")));
                        request.getRequestDispatcher("WEB-INF/jsp/VendaForms/VendaManage.jsp")
                                .forward(request, response);
                        return;
                    }
                }
            }else if(command.compareToIgnoreCase("qtdProd") == 0){
                Venda venda = (Venda) sessao.getAttribute("venda");

                for (int i = 0; i < venda.getItens().size(); i++) {
                    if (venda.getItens().get(i).getIdProd().getId() == Integer.parseInt(request.getParameter("obj"))) {
                        venda.getItens().get(i).setQuantidade(Integer.parseInt(request.getParameter("qtd")));
                        request.getRequestDispatcher("WEB-INF/jsp/VendaForms/VendaManage.jsp")
                                .forward(request, response);
                        return;
                    }
                }
            }
            

        } catch (Exception e) {
            request.setAttribute("response", "ERRO!");
        }
        request.getRequestDispatcher("WEB-INF/jsp/VendaForms/VendaManage.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        VendaDAO vendaDAO = new VendaDAO();
        
        try {
            HttpSession sessao = request.getSession();
            Venda venda = (Venda) sessao.getAttribute("venda");
            
            if (vendaDAO.insert(venda)) {
                sessao.removeAttribute("venda");
                sessao.removeAttribute("clienteV");
                request.setAttribute("response", "VENDA REALIZADA COM SUCESSO!");
            }else{
                request.setAttribute("response", "ERRO!");
            }
            
        } catch (Exception e) {

            request.setAttribute("response", "ERRO!");

        }

        request.getRequestDispatcher("WEB-INF/jsp/VendaForms/reponseInsertVenda.jsp")
                .forward(request, response); 

    }
}

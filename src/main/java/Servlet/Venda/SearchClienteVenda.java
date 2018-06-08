/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet.Venda;

import Servlet.*;
import Model.DAO.ClienteDAO;
import Model.Entity.Cliente;
import Model.Entity.Venda;
import java.io.IOException;
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
@WebServlet(name = "SearchClienteVenda", urlPatterns = {"/searchClienteVenda"})
public class SearchClienteVenda extends HttpServlet {

    ClienteDAO clienteDAO = new ClienteDAO();
    Cliente cli = null;
    List<Cliente> listCliente = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        Venda venda = (Venda) sessao.getAttribute("venda");
        if (venda != null && venda.getIdcliente() != 0) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/VendaForms/SearchClienteVenda.jsp");
            dispatcher.forward(request, response);
            return;
        }

        String nomeCli = null;
        nomeCli = request.getParameter("nomeCli");
        try {
            if (nomeCli != null && nomeCli.compareToIgnoreCase("") != 0) {
                listCliente = clienteDAO.buscaNome(nomeCli);
            } else {
                listCliente = clienteDAO.selectAll();
            }

            request.setAttribute("listCliente", listCliente);

        } catch (Exception e) {
            listCliente = null;
            request.setAttribute("listCliente", listCliente);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/VendaForms/SearchClienteVenda.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        try {
            Venda venda = new Venda();
            venda.setIdcliente(Integer.parseInt(request.getParameter("idCli1")));
            cli = clienteDAO.selectId(Integer.parseInt(request.getParameter("idCli1")));
            sessao.setAttribute("venda", venda);
            sessao.setAttribute("clienteV", cli);
            sessao.setAttribute("statusProd", "none");
            sessao.setAttribute("statusServ", "none");
            request.getRequestDispatcher("WEB-INF/jsp/VendaForms/SearchCarrinhoVenda.jsp")
                    .forward(request, response);
        } catch (Exception e) {
            sessao.removeAttribute("venda");
            sessao.removeAttribute("clienteV");
            request.getRequestDispatcher("WEB-INF/jsp/VendaForms/ManageVenda.jsp")
                    .forward(request, response);
        }

    }

}

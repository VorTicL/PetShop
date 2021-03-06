/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Model.DAO.ClienteDAO;
import Model.Entity.Cliente;
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
@WebServlet(name = "SearchCliente", urlPatterns = {"/searchCliente"})
public class SearchClienteServlet extends HttpServlet {
    ClienteDAO clienteDAO = new ClienteDAO();
    Cliente cli = null;
    List<Cliente> listCliente = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nomeCli = null;
        nomeCli = request.getParameter("nomeCli");
        try {
            if (nomeCli != null && nomeCli.compareToIgnoreCase("") != 0) {
                listCliente = clienteDAO.buscaNome(nomeCli);
            }else{
                listCliente = clienteDAO.selectAll();
            }
            
            request.setAttribute("listCliente", listCliente);

        } catch (Exception e) {
            listCliente = null;
            request.setAttribute("listCliente", listCliente);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/ClienteForm/SearchCliente.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try {
            Cliente cliente = clienteDAO.selectId(Integer.parseInt(request.getParameter("idCliente1")));
            HttpSession sessao = request.getSession();
            sessao.setAttribute("manageCliente", cliente);
            request.setAttribute("cliente", cliente);
            
            request.getRequestDispatcher("WEB-INF/jsp/ClienteForm/ManageCliente.jsp")
                    .forward(request, response);
        } catch (Exception e) {
            request.getRequestDispatcher("WEB-INF/jsp/ClienteForm/SearchCliente.jsp")
                    .forward(request, response);
        }
        
    }

}

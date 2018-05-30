/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Model.DAO.ClienteDAO;
import Model.DAO.ModelCommercialServicosDao;
import Model.Entity.Cliente;
import Model.Entity.ModelCommercialProduct;
import Model.Entity.ModelCommercialService;
import ServiceMock.MockProduto;
import ServiceMock.MockService;
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
            int idCli = Integer.parseInt(request.getParameter("idCli"));
            
            cli = clienteDAO.selectId(idCli);

            request.setAttribute("cliente", cli);

            request.getRequestDispatcher("WEB-INF/jsp/ClienteForm/ManageCliente.jsp")
                    .forward(request, response);
        } catch (Exception e) {
            request.getRequestDispatcher("WEB-INF/jsp/ClienteForm/SearchCliente.jsp")
                    .forward(request, response);
        }
        request.getRequestDispatcher("WEB-INF/jsp/ClienteForm/SearchCliente.jsp")
                    .forward(request, response);
        
    }

}

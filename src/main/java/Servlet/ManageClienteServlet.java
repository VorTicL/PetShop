/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Model.DAO.ClienteDAO;
import Model.Entity.Cliente;
import java.io.IOException;
import java.sql.Timestamp;
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
@WebServlet(name = "ManageCliente", urlPatterns = {"/manageCliente"})
public class ManageClienteServlet extends HttpServlet {

    ClienteDAO clienteDAO = new ClienteDAO();
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        try {
            HttpSession sessao = request.getSession();

            Cliente cliente = (Cliente) sessao.getAttribute("manageCliente");
            
            cliente.setNome(request.getParameter("nomeCli"));
            cliente.setSexo(request.getParameter("sexoCli"));
            cliente.setRg(request.getParameter("rgCli"));
            cliente.setCpf(request.getParameter("cpfCli"));
            cliente.setEndereco(request.getParameter("enderecoCli"));
            

            
            if (clienteDAO.update(cliente)) {
                request.setAttribute("response", "Cliente Alterado Com Sucesso!");
            }else{
                request.setAttribute("response", "ERRO!");
            }
            
        } catch (Exception e) {
            request.setAttribute("response", "ERRO!");
        }
        request.getRequestDispatcher("WEB-INF/jsp/ClienteForm/ResponseManageCliente.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int idRemove = Integer.parseInt(request.getParameter("idCliente"));
            if (clienteDAO.delete(idRemove)) {
                request.setAttribute("response", "Cliente Removido Com Sucesso!");
            }else{
                request.setAttribute("response", "ERRO!");
            }
        } catch (Exception e) {
            request.setAttribute("response", "ERRO!");
        }
        request.getRequestDispatcher("WEB-INF/jsp/ClienteForm/ResponseManageCliente.jsp")
                .forward(request, response);

    }
}

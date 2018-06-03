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
            int id = Integer.parseInt(request.getParameter("id"));
            String nome = request.getParameter("nomeCli");
            String dataNasc = request.getParameter("dataNasc");
            String sexo = request.getParameter("sexo");
            String rg = request.getParameter("rg");
            String cpf = request.getParameter("cpf");
            String endereco = request.getParameter("endereco");

            Cliente cli = new Cliente();
            cli.setNome(nome);
            cli.setDataNasc(Timestamp.valueOf(dataNasc));
            cli.setSexo(sexo);
            cli.setRg(rg);
            cli.setCpf(cpf);
            cli.setEndereco(endereco);
            cli.setId(id);

            if (clienteDAO.update(cli)) {
                request.setAttribute("response", "Produto Alterado Com Sucesso!");
            } else {
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
            int idRemove = Integer.parseInt(request.getParameter("id"));

            if (clienteDAO.delete(idRemove)) {
                request.setAttribute("response", "Produto Removido Com Sucesso!");
            } else {
                request.setAttribute("response", "ERRO!");
            }

        } catch (Exception e) {
            request.setAttribute("response", "ERRO!");
        }
        request.getRequestDispatcher("WEB-INF/jsp/ClienteForm/ResponseManageCliente.jsp")
                .forward(request, response);

    }
}

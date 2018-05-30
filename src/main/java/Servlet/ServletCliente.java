/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Model.DAO.ClienteDAO;
import Model.DAO.ModelCommercialProductDao;
import Model.Entity.Cliente;
import Model.Entity.ModelCommercialProduct;
import ServiceMock.MockProduto;
import java.io.IOException;
import java.sql.Timestamp;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author victor.rslucca
 */
@WebServlet(name = "ClienteServlet", urlPatterns = {"/cliente"})
public class ServletCliente extends HttpServlet {
    ClienteDAO clienteDAO = new ClienteDAO();
    Cliente cli = new Cliente();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp"
                + "/ClienteForm/ClienteForm.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String nome = request.getParameter("nomeCli");
            String dataNasc = request.getParameter("dataNasc");
            String sexo = request.getParameter("sexo");
            String rg = request.getParameter("rg");
            String cpf = request.getParameter("cpf");
            String endereco = request.getParameter("endereco");

            cli = new Cliente();
            cli.setNome(nome);
            cli.setDataNasc(Timestamp.valueOf(dataNasc));
            cli.setSexo(sexo);
            cli.setRg(rg);
            cli.setCpf(cpf);
            cli.setEndereco(endereco);
            cli.setId(id);
            if (clienteDAO.insert(cli)) {
                request.setAttribute("response", cli.getNome() + "Cadastrado com sucesso!");
            } else {
                request.setAttribute("response", "ERRO!");
            }
        } catch (Exception e) {
            request.setAttribute("response", "ERRO!");
        } finally {
            request.getRequestDispatcher("WEB-INF/jsp/ClienteForm/ResponseInsertCliente.jsp")
                    .forward(request, response);
        }

    }

}

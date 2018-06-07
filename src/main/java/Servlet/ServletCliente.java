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
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

      Cliente cli = new Cliente();
      try {
            cli.setNome(request.getParameter("nomeCli"));
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date parsedDate = dateFormat.parse(request.getParameter("dataNascCli"));
            Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
            cli.setDataNasc(timestamp);
            cli.setSexo(request.getParameter("sexoCli"));
            cli.setRg(request.getParameter("rgCli"));
            cli.setDataCri(new Timestamp(System.currentTimeMillis()));
            cli.setCpf(request.getParameter("cpf"));
            cli.setEndereco(request.getParameter("enderecoCli"));
            

            ClienteDAO clienteDAO = new ClienteDAO();
            if (clienteDAO.insert(cli)) {
                request.setAttribute("response", "Cliente adicionado com sucesso");
            } else {
                request.setAttribute("response", "ERRO!");
            }
        } catch (Exception e) {
            request.setAttribute("response", "ERRO!");
        }
        request.getRequestDispatcher("WEB-INF/jsp/ClienteForms/ResponseInsertCliente.jsp").forward(request, response);
    }
      

    }



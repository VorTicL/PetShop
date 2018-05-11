/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Model.Entity.Funcionario;
import ServiceMock.MockFuncionario;
import java.io.IOException;
import java.io.PrintWriter;
import Model.DAO.FuncionarioDao;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author João
 */
@WebServlet(name = "FuncionarioServlet", urlPatterns = {"/funcionario"})
public class FuncionarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp"
                + "/UserForms/funcionarioForm.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
      Funcionario funcionario = new Funcionario(
              0, 0, request.getParameter("nomeFunc"),request.getParameter("dataNasc"),
              request.getParameter("sexo"),request.getParameter("rg"),request.getParameter("cpf"),
              null
      );
      FuncionarioDao funcionarioDao = new  FuncionarioDao();
      
      int id = funcionarioDao.insert(funcionario);
      request.getRequestDispatcher("WEB-INF/jsp/UserForms/funcionarioForm.jsp").forward(request, response);
      
      
    }
}

 


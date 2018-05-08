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
                + "/CommercialForms/funcionarioForm.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       try {
            String nome = request.getParameter("nomeFunc");
            String dataNasc = request.getParameter("dataNasc");
            String  sexo = request.getParameter("sexo");
            String  rg = request.getParameter("rg");
            String  cpf = request.getParameter("cpf");
            

           /* Funcionario func1 = new Funcionario( nome,dataNasc,sexo,rg,cpf);
            MockFuncionario.inserirFuncionario(func1);
            request.setAttribute("funcionarioResponse",  func1.getNome()+"Cadastrado com sucesso!");
           */
        } catch (Exception e) {
            request.setAttribute("funcionarioResponse", "ERRO!");
        }finally{
            request.getRequestDispatcher("WEB-INF/jsp/responseFuncionario.jsp")
                    .forward(request, response);
        }
    }
    }

 


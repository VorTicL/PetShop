/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;


import Model.Entity.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author João
 */
@WebServlet(name = "ManageUser", urlPatterns = {"/manageUser"})
public class ManageUserServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            
        
            User func = new User();
        func.setId(Integer.parseInt(request.getParameter("idFunc")));
        func.setNome(request.getParameter("nomeFunc"));
        func.setDataNasc(request.getParameter("dataNasc"));
        func.setSexo(request.getParameter("sexo"));
       func.setRg(request.getParameter("rg"));
       func.setCpf(request.getParameter("cpf"));
        
        //MockFuncionario.alterar(func);
        
        request.setAttribute("response", "Funcionario Alterado Com Sucesso!");
        } catch (Exception e) {
            request.setAttribute("response", "ERRO!");
        }
        request.getRequestDispatcher("WEB-INF/jsp/UserForms/responseManageFuncionario.jsp")
                    .forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         try {
        int idRemove = Integer.parseInt(request.getParameter("idFunc"));
             //MockFuncionario.remover(idRemove);
        request.setAttribute("response", "Funcionario Removido Com Sucesso!");
        } catch (Exception e) {
            request.setAttribute("response", "ERRO!");
        }
        request.getRequestDispatcher("WEB-INF/jsp/UserForms/responseManageFuncionario.jsp")
                    .forward(request, response);
        
    }
}

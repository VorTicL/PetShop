/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Model.DAO.UserDAO;
import Model.Entity.User;
import java.io.IOException;
import java.sql.Timestamp;
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
@WebServlet(name = "User", urlPatterns = {"/user"})
public class ServletUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp"
                + "/UserForms/UserForm.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        User user = new User();
        try{
        user.setLogin(request.getParameter("user"));
        user.setSenha(request.getParameter("senha"));
        user.setIdFilial(Integer.parseInt(request.getParameter("filial")));
        user.setEmail(request.getParameter("email"));
        user.setDataCri(new Timestamp(System.currentTimeMillis()));
        user.setCpf(request.getParameter("cpf"));
        user.setDataNasc(Timestamp.valueOf(request.getParameter("dataNasc")));
        user.setNome(request.getParameter("nome"));
        user.setSobrenome(request.getParameter("sobrenome"));
        user.setSexo(request.getParameter("sexo"));
        user.setRg(request.getParameter("rg"));
        user.setType(request.getParameter("typeUser"));
        
            UserDAO userDAO = new UserDAO();
            if(userDAO.insert(user)){
                 request.setAttribute("response", "Funcionario adicionado com sucesso");
            }else{
                 request.setAttribute("response", "ERRO!");
            }
        }catch(Exception e){
             request.setAttribute("response", "ERRO!");
        }
        request.getRequestDispatcher("WEB-INF/jsp/UserForms/ResponseInsertUser.jsp").forward(request, response);
    }
}

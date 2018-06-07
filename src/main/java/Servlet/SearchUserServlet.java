/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Model.DAO.UserDAO;
import Model.Entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 *
 * @author João
 */
@WebServlet(name = "SearchFuncionario", urlPatterns = {"/searchUser"})
public class SearchUserServlet extends HttpServlet {

    UserDAO userDAO = new UserDAO();
    List<User> userList = new ArrayList<User>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = "";
        nome = request.getParameter("nomeUser");
        try {
            if (nome == null || nome.compareToIgnoreCase("") == 0) {
                userList = userDAO.selectAll();
            }else{
                userList = userDAO.selectNome(nome);
            }
        } catch (Exception e) {
            userList = null;
        }
        request.setAttribute("listUser", userList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/UserForms/SearchUser.jsp");
        
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            User user = userDAO.selectId(Integer.parseInt(request.getParameter("idUser1")));
            HttpSession sessao = request.getSession();
            sessao.setAttribute("manageUser", user);
            request.setAttribute("user", user);
            
            request.getRequestDispatcher("WEB-INF/jsp/UserForms/ManageUser.jsp")
                    .forward(request, response);
        } catch (Exception e) {
            request.getRequestDispatcher("WEB-INF/jsp/UserForms/SearchUser.jsp")
                    .forward(request, response);
        }
    }

}

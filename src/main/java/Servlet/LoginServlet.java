/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Model.DAO.FilialDAO;
import Model.DAO.UserDAO;
import Model.Entity.Filial;
import Model.Entity.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        // Logica para evitar q usuario logado acesse pagina de login
        HttpSession sessao = request.getSession();
        if (sessao.getAttribute("usuario") != null) {
            response.sendRedirect(request.getContextPath() + "/home");
            return;
        }
        request.getRequestDispatcher("/index.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String senha = request.getParameter("senha");

        User user;
        Map<Integer, Filial> filial;
        
        UserDAO userDAO = new UserDAO();
        FilialDAO filialDAO = new FilialDAO();
        try {
            
            user = userDAO.login(username, senha);
            
            if (user != null) {
                HttpSession sessao = request.getSession();
                filial = filialDAO.selectAll();
                List<String> types = new ArrayList<>();
                types.add("GERENTE");
                types.add("ESTOQUISTA");
                types.add("VENDEDOR");
                types.add("DIRETOR");
                sessao.setAttribute("usuario", user);
                sessao.setAttribute("filiais", filial);
                sessao.setAttribute("type", types);
                response.sendRedirect(request.getContextPath() + "/home");

            } else {
                request.setAttribute("msgErro", "Usuário ou senha inválido");
                request.getRequestDispatcher("WEB-INF/jsp/erro-login.jsp")
                        .forward(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("msgErro", "Usuário ou senha inválido");
            request.getRequestDispatcher("WEB-INF/jsp/erro-login.jsp")
                        .forward(request, response);
        }

    }
}

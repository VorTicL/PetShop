/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Model.Entity.Iuser;
import ServiceMock.MockUsuario;
import java.io.IOException;
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

        // Validar as informações
        MockUsuario mockUsuario = new MockUsuario();
        Iuser usuario = mockUsuario.buscarPorUsername(username);
        if (usuario != null && usuario.validarSenha(senha)) {
            HttpSession sessao = request.getSession();
            sessao.setAttribute("usuario", usuario);
            response.sendRedirect(request.getContextPath() + "/home");
        } else {

            request.setAttribute("msgErro", "Usuário ou senha inválido");
            request.getRequestDispatcher("WEB-INF/jsp/erro-login.jsp")
                    .forward(request, response);
        }

    }
}
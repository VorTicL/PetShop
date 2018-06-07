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
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author João
 */
@WebServlet(name = "ManageUser", urlPatterns = {"/manageUser"})
public class ManageUserServlet extends HttpServlet {

    UserDAO userDAO = new UserDAO();
    
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        try {
            HttpSession sessao = request.getSession();

            User user = (User) sessao.getAttribute("manageUser");
            
            user.setLogin(request.getParameter("user"));
            user.setSenha(request.getParameter("senha"));
            user.setIdFilial(Integer.parseInt(request.getParameter("filial")));
            user.setEmail(request.getParameter("email"));
            user.setCpf(request.getParameter("cpf"));
            user.setNome(request.getParameter("nome"));
            user.setSobrenome(request.getParameter("sobrenome"));
            user.setSexo(request.getParameter("sexo"));
            user.setRg(request.getParameter("rg"));
            user.setType(request.getParameter("typeUser"));

            
            if (userDAO.update(user)) {
                request.setAttribute("response", "Usuario Alterado Com Sucesso!");
            }else{
                request.setAttribute("response", "ERRO!");
            }
            
        } catch (Exception e) {
            request.setAttribute("response", "ERRO!");
        }
        request.getRequestDispatcher("WEB-INF/jsp/UserForms/ResponseManageUser.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int idRemove = Integer.parseInt(request.getParameter("idUser"));
            if (userDAO.delete(idRemove)) {
                request.setAttribute("response", "Usuario Removido Com Sucesso!");
            }else{
                request.setAttribute("response", "ERRO!");
            }
        } catch (Exception e) {
            request.setAttribute("response", "ERRO!");
        }
        request.getRequestDispatcher("WEB-INF/jsp/UserForms/ResponseManageUser.jsp")
                .forward(request, response);
    }
}

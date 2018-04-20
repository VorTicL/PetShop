/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import com.javadbc.petshoppi.model.ModelCommercialProduct;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gabra
 */
@WebServlet(name = "commercialService", urlPatterns = {"/comm-service"})
public class CommercialService extends HttpServlet{
    @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
    
    int id = Integer.parseInt(request.getParameter("idSelected"));
    String action = request.getParameter("action");
        if (action.compareToIgnoreCase("search")==0) {
            System.out.println("PROCURAR" + id);
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/cliente-mvc.jsp");
            dispatcher.forward(request, response);
        }
        if (action.compareToIgnoreCase("choose")==0) {
            System.out.println("SELECIONOU"+id);
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/cliente-mvc.jsp");
            dispatcher.forward(request, response);
        }
    
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {

  }

}

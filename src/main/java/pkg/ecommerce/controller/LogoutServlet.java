package pkg.ecommerce.controller;

import pkg.ecommerce.dao.ECommerceDAO;
import pkg.ecommerce.service.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
    private ECommerceDAO eCommerceDAO;
    @Override
    public void init() throws ServletException {
        eCommerceDAO = new ECommerceDAO();
    }
    public LogoutServlet(){

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session!=null){
            session.removeAttribute("username");
            session.removeAttribute("password");
            session.invalidate();
        }
        response.sendRedirect("/LoginServlet");
    }
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    }
}

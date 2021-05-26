package pkg.ecommerce.controller;

import pkg.ecommerce.dao.ECommerceDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
    private ECommerceDAO eCommerceDAO;

    @Override
    public void init() throws ServletException {
        ECommerceDAO eCommerceDAO = new ECommerceDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/home.jsp");
        requestDispatcher.forward(req,resp);
    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//    }
}

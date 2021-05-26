package pkg.ecommerce.controller;

import pkg.ecommerce.dao.ECommerceDAO;
import pkg.ecommerce.service.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/ListServlet")
public class ListServlet extends HttpServlet {
    private ECommerceDAO eCommerceDAO;
    @Override
    public void init() throws ServletException {
        eCommerceDAO = new ECommerceDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("products",eCommerceDAO.getAllProduct());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/productPage.jsp");
        requestDispatcher.forward(req,resp);
    }
}

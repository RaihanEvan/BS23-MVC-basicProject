package pkg.ecommerce.controller;

import pkg.ecommerce.dao.DBClass;
import pkg.ecommerce.dao.ECommerceDAO;
import pkg.ecommerce.service.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private ECommerceDAO eCommerceDAO;
    @Override
    public void init() throws ServletException {
        eCommerceDAO = new ECommerceDAO();
    }
    public LoginServlet(){

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/login.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        String destinationPage = "/WEB-INF/views/login.jsp";
//        try {
//            User user = eCommerceDAO.checkLogin("username","password");
//            if(user != null){
//                HttpSession httpSession = request.getSession();
//                httpSession.setAttribute("user",user);
//                destinationPage = "/WEB-INF/views/home.jsp";
//            }else {
//                String message = "Invalid Username/Password";
//                request.setAttribute("message",message);
//            }
//            RequestDispatcher requestDispatcher = request.getRequestDispatcher(destinationPage);
//            requestDispatcher.forward(request,response);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }


//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        String page = "";
//        User user = new User();
//        user.setUsername(username);
//        user.setPassword(password);
//
//        try {
//            if (eCommerceDAO.validate(user)) {
//                HttpSession session = request.getSession();
//                session.setAttribute("username",username);
//                session.setAttribute("password",password);
//                page = "/WEB-INF/views/productPage.jsp"; //if given servlet gives HTTP method POST is not supported by this URL error
//                request.setAttribute("products",eCommerceDAO.getAllProduct());
//
////                response.sendRedirect("/WEB-INF/views/productPage.jsp");
//            } else {
//                page = "/WEB-INF/views/login.jsp";
////                response.sendRedirect("/WEB-INF/views/login.jsp");
//            }
//            RequestDispatcher requestDispatcher = request.getRequestDispatcher(page);
//            requestDispatcher.forward(request,response);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String page = "";

        if(username.equals("admin") && password.equals("admin")){
            HttpSession session = request.getSession();

            session.setAttribute("username",username);
            session.setAttribute("password",password);
            page = "/WEB-INF/views/productPage.jsp"; //if given servlet gives HTTP method POST is not supported by this URL error
            request.setAttribute("products",eCommerceDAO.getAllProduct());
        }else {
                page = "/WEB-INF/views/login.jsp";
//                response.sendRedirect("/WEB-INF/views/login.jsp");
            }
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(page);
            requestDispatcher.forward(request,response);
    }
}

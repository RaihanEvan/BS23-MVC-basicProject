package pkg.ecommerce.controller;

import pkg.ecommerce.dao.ECommerceDAO;
import pkg.ecommerce.service.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import javax.servlet.http.HttpSession;


@WebServlet("/ECommerceServlet")
public class ECommerceServlet extends HttpServlet {
    private ECommerceDAO eCommerceDAO;

    @Override
    public void init() throws ServletException {
        eCommerceDAO = new ECommerceDAO();
    }

    public ECommerceServlet() {
        eCommerceDAO = new ECommerceDAO();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NumberFormatException {

        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        String password = (String) session.getAttribute("password");
//        session.setAttribute("username",username);
//        session.setAttribute("password",password);
        try {
            if (username.equals("admin") && password.equals("admin")) {

                String page = "";
                String action = request.getParameter("action");

                if (action.equals("delete")) {
                    int pid = Integer.parseInt(request.getParameter("pid"));
                    eCommerceDAO.deleteProduct(pid); //DELETE Method
                    page = "/WEB-INF/views/productPage.jsp";
                    request.setAttribute("products", eCommerceDAO.getAllProduct());
                } else if (action.equals("update")) {
                    page = "/WEB-INF/views/productFormPage.jsp";
                    int pid = Integer.parseInt(request.getParameter("pid"));
                    Product product = eCommerceDAO.getProductById(pid);
                    request.setAttribute("product", product);
                } else if (action.equals("create")) {
                    page = "/WEB-INF/views/productFormPage.jsp";
                } else {
                    page = "/WEB-INF/views/productPage.jsp";
                    request.setAttribute("products", eCommerceDAO.getAllProduct()); //Read Method
                }

                RequestDispatcher requestDispatcher = request.getRequestDispatcher(page);
                requestDispatcher.forward(request, response);
//
            } else {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/errorPage.jsp");
                requestDispatcher.forward(request, response);
            }
        }catch (NullPointerException e){
//            e.printStackTrace();
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/errorPage.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        String name = request.getParameter("name");
//        int quantity = Integer.parseInt(request.getParameter("quantity"));
//        String manufacturer = request.getParameter("manufacturer");
//        int warranty = Integer.parseInt(request.getParameter("warranty"));
//        float price = Float.parseFloat(request.getParameter("price"));
        //Product product = new Product(name,quantity,manufacturer,warranty,price);


        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        String password = (String) session.getAttribute("password");
        session.setAttribute("username",username);
        session.setAttribute("password",password);
        if (session != null) {

            Product product = new Product();
            product.setName(request.getParameter("name"));
            product.setQuantity(Integer.parseInt(request.getParameter("quantity")));
            product.setManufacturer(request.getParameter("manufacturer"));
            product.setWarranty(Integer.parseInt(request.getParameter("warranty")));
            product.setPrice(Float.parseFloat(request.getParameter("price")));
            String pid = request.getParameter("pid");
            if (pid == null || pid.isEmpty()) {
                eCommerceDAO.addProduct(product); //ADD METHOD
            } else {
                product.setPid(Integer.parseInt(pid));
                eCommerceDAO.updateProduct(product); //UPDATE METHOD
            }

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/productPage.jsp");
            request.setAttribute("products", eCommerceDAO.getAllProduct());
            requestDispatcher.forward(request, response);

        } else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/errorPage.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
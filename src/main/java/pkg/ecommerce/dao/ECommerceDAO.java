package pkg.ecommerce.dao;

import pkg.ecommerce.service.Product;
import pkg.ecommerce.service.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ECommerceDAO {
    private Connection connection;

    public ECommerceDAO() {
        connection = DBClass.getConnection();
    }

    public void addProduct(Product product) {
        try {
            String INSERT_PRODUCT_SQL = "INSERT INTO products" + "(pid,name,quantity,manufacturer,warranty,price) VALUES" + "(?,?,?,?,?,?);";

            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT_SQL);
            preparedStatement.setInt(1, product.getPid());
            preparedStatement.setString(2, product.getName());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setString(4, product.getManufacturer());
            preparedStatement.setInt(5, product.getWarranty());
            preparedStatement.setDouble(6, product.getPrice());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            //connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteProduct(int pid){
        try{
            String DELETE_PRODUCT_SQL = "DELETE FROM products WHERE pid=?";

            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT_SQL);
            preparedStatement.setInt(1,pid);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            //connection.close();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    public void updateProduct(Product product){
        try{
            String UPDATE_PRODUCT_SQL = "UPDATE products SET name=?,quantity=?,manufacturer=?,warranty=?,price=? WHERE pid=?";

            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT_SQL);
            preparedStatement.setString(1,product.getName());
            preparedStatement.setInt(2,product.getQuantity());
            preparedStatement.setString(3,product.getManufacturer());
            preparedStatement.setInt(4,product.getWarranty());
            preparedStatement.setFloat(5,product.getPrice());
            preparedStatement.setInt(6,product.getPid());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            //connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    //public void listAllProduct()
    public List<Product> getAllProduct(){
        List<Product> products = new ArrayList<>();
        try{
            String PRINT_PRODUCT_SQL = "SELECT * FROM products";

            //PreparedStatement preparedStatement = connection.prepareStatement(PRINT_PRODUCT_SQL);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(PRINT_PRODUCT_SQL);
            while(resultSet.next()){
                Product product = new Product();
                product.setPid(resultSet.getInt("pid"));
                product.setName(resultSet.getString("name"));
                product.setQuantity(resultSet.getInt("quantity"));
                product.setManufacturer(resultSet.getString("manufacturer"));
                product.setWarranty(resultSet.getInt("warranty"));
                product.setPrice(resultSet.getFloat("price"));
                products.add(product);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
    public Product getProductById(int pid){
        Product product = new Product();
        String PRINT_PRODUCT_BY_ID_SQL = "SELECT * FROM products WHERE pid=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(PRINT_PRODUCT_BY_ID_SQL);
            preparedStatement.setInt(1,pid);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                product.setPid(resultSet.getInt("pid"));
                product.setName(resultSet.getString("name"));
                product.setQuantity(resultSet.getInt("quantity"));
                product.setManufacturer(resultSet.getString("manufacturer"));
                product.setWarranty(resultSet.getInt("warranty"));
                product.setPrice(resultSet.getFloat("price"));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
return product;

    }
    public User checkLogin(String username, String password) throws ClassNotFoundException, SQLException {
        String jdbcURL = "jdbc:mysql://localhost:3307/users";
        String dbUser = "root";
        String dbPassword = "";

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
        String sql = "SELECT * FROM users WHERE email = ? and password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);

        ResultSet resultSet = preparedStatement.executeQuery();

        User user = null;
        if(resultSet.next()){
            user = new User();
//            user.setFullname(resultSet.getString("fullname"));
            user.setUsername(username);
        }
        connection.close();
        return user;
    }
    public boolean validate(User user) throws ClassNotFoundException {
        boolean status = false;

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3307/ecommerce1", "root", "");

             PreparedStatement preparedStatement = connection
                     .prepareStatement("select * from users where username = ? and password = ? ")) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());

            ResultSet rs = preparedStatement.executeQuery();
            status = rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }
}
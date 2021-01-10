package AccessClasses;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderRequest {
    Order order;
    List<Product> products;
    public OrderRequest(int customerId) {
        String dbUrl = System.getenv("JDBC_DATABASE_URL");
        try {
            Class.forName("org.postgresql.Driver");
            Connection db = DriverManager.getConnection(dbUrl);
            Statement stmt = db.createStatement();
            String sqlStr = "SELECT * FROM orders WHERE customer_id = " + customerId;
            ResultSet rs = stmt.executeQuery(sqlStr);
            this.products = new ArrayList<>();
            while (rs.next()) {
                int orderId = rs.getInt("id");
                String sqlStr2 = "SELECT * FROM ordered_product WHERE orders_id = " + orderId;
                ResultSet rs2 = stmt.executeQuery(sqlStr2);
                while (rs2.next()){
                    //String name,String brand, int change, float unitPrice
                    Product p = new Product(rs2.getString("name"), rs2.getString("brand"), rs2.getInt("quantity"), rs2.getFloat("sell_price"));
                    products.add(p);
                }
            }
            this.order = new Order(products, customerId);
            rs.close();
            stmt.close();
            db.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Product> getOrder() {
        return products;
    }
}

package AccessClasses;

import java.sql.*;
import java.util.List;

public class CreateOrder {
    int orderId;
    public CreateOrder(List<Product> products, int customer){
        String dbUrl = System.getenv("JDBC_DATABASE_URL");
        try {
            Class.forName("org.postgresql.Driver");
            Connection db = DriverManager.getConnection(dbUrl);
            Statement stmt = db.createStatement();
            stmt.execute("INSERT INTO orders(customer_id, date) VALUES(" + customer + ",CURRENT_DATE);");
            ResultSet rs = stmt.executeQuery("SELECT* FROM orders WHERE customer_id =" + customer + " AND date = CURRENT_DATE);");
            if (rs.next()) {
                this.orderId = rs.getInt("id");
            }
            for(int i = 0; i< products.size(); i++) {
                stmt.execute("INSERT INTO ordered_product(barcode, name, orders_id, quantity, sell_price, brand) VALUES(1," + products.get(i).getName()+ "," + this.orderId + "," + products.get(i).getChange() + "," + products.get(i).getUnitPrice() + "," + products.get(i).getBrand() + ")");
            }



        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}

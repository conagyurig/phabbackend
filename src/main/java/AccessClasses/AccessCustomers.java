package AccessClasses;

import java.sql.*;

public class AccessCustomers {
    Customers customers;
    public AccessCustomers(){
        String dbUrl = System.getenv("JDBC_DATABASE_URL");
            try {
            Class.forName("org.postgresql.Driver");
            Connection db = DriverManager.getConnection(dbUrl);
            Statement stmt = db.createStatement();
            String sqlStr = "SELECT * FROM Customers";
            ResultSet rs = stmt.executeQuery(sqlStr);
                if (rs.next()) {
                    //String address, String email, String first_name, int id, String last_name, String phone_no, String postcode){
                    Customer customer = new Customer(rs.getString("address"),rs.getString("email"),rs.getString("first_name"),rs.getInt("id"),rs.getString("last_name"),rs.getString("phone_no"),rs.getString("postcode"));
                    this.customers.addCustomers(customer);
                }
                rs.close();
                stmt.close();
                db.close();
        }
            catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public Customers getCustomers() {
        return customers;
    }
}

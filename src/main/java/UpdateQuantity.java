import java.sql.*;

public class UpdateQuantity {
    public int quant;

    public UpdateQuantity(String name1, String brand1, int change) {
        String dbUrl = System.getenv("JDBC_DATABASE_URL");
        try {
            Class.forName("org.postgresql.Driver");
            Connection db = DriverManager.getConnection(dbUrl);
            Statement stmt = db.createStatement();
            String sqlStr = "SELECT * FROM shop_product WHERE name = " + name1 + " AND brand = " + brand1;
            System.out.println(sqlStr);
            ResultSet rs = stmt.executeQuery(sqlStr);
            if (rs.next()) {
                quant = rs.getInt("quantity");
                System.out.println(quant);
            }
            int update = quant + change;
            stmt.execute("UPDATE shop_product SET quantity = " + update +  " WHERE name = " + name1 + " AND brand = " + brand1 + ";");
            rs.close();
            stmt.close();
            db.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
import java.sql.*;

public class UpdateQuantity {
    public int quant;
    private float sellPrice;
    private float buyPrice;

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
                sellPrice = rs.getFloat("sell_price");
                buyPrice = rs.getFloat("buy_price");
                System.out.println(quant);
            }
            if (change < 0) {
                float oldProfit = 0;
                float newProfit = 0;
                rs = stmt.executeQuery("SELECT * FROM daily_profit WHERE date = CURRENT_DATE ;");
                if (rs.next()) {
                    oldProfit = rs.getFloat("profit");
                }
                else {
                    oldProfit = 0;
                    stmt.execute("INSERT INTO daily_profit(date, profit) VALUES(CURRENT_DATE,0);");
                }
                float saleProfit = -change * (sellPrice - buyPrice);
                newProfit = oldProfit + saleProfit;
                stmt.execute("UPDATE daily_profit SET profit = " + newProfit + " WHERE date = CURRENT_DATE;");
            }
            int update = quant + change;
            stmt.execute("UPDATE shop_product SET quantity = " + update + " WHERE name = " + name1 + " AND brand = " + brand1 + ";");
            rs.close();
            stmt.close();
            db.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}